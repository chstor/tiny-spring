package cn.chstor.springframework.beans.factory.xml;

import cn.chstor.springframework.beans.BeansException;
import cn.chstor.springframework.beans.PropertyValue;
import cn.chstor.springframework.beans.factory.config.BeanDefinition;
import cn.chstor.springframework.beans.factory.config.BeanReference;
import cn.chstor.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import cn.chstor.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.chstor.springframework.core.io.Resource;
import cn.chstor.springframework.core.io.ResourceLoader;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : bing
 * @date : 2024/8/8 9:50
 * @modyified By :
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try (InputStream is = resource.getInputStream()){
            doLoadBeanDefinitions(is);
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for(Resource resource : resources){
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException{
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for(int i = 0; i < childNodes.getLength(); ++ i){
            //判断元素
            if(!(childNodes.item(i) instanceof Element)) continue;
            //判断对象
            if(!("bean".equals(childNodes.item(i).getNodeName()))) continue;
            Element bean = (Element)childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            Class<?> clazz = Class.forName(className);
            //id>name
            String beanName = StrUtil.isNotBlank(id) ? id : name;
            if(StrUtil.isBlank(beanName)){
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }
            //定义Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            NodeList beanChildNodes = bean.getChildNodes();
            for(int j = 0; j < beanChildNodes.getLength(); j ++){
                if(!(beanChildNodes.item(j) instanceof Element)) continue;
                if(!("property".equals(beanChildNodes.item(j).getNodeName()))) continue;
                Element property = (Element) beanChildNodes.item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                Object value = StrUtil.isNotBlank(attrRef) ? new BeanReference(attrRef) : attrValue;
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 注册 BeanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
