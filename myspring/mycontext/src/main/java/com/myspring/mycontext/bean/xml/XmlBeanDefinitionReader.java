package com.myspring.mycontext.bean.xml;

import com.myspring.mycontext.bean.AbstractBeanDefinitionReader;
import com.myspring.mycontext.bean.BeanDefinition;
import com.myspring.mycontext.bean.PropertyValue;
import com.myspring.mycontext.exception.beanexception.BeanException;
import com.myspring.mycontext.bean.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @DateTime 2020/1/21 3:52 下午
 * @Author yang
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanfinitions(inputStream);
    }

    protected void doLoadBeanfinitions(InputStream inputStream) throws Exception {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            registerBeanDefinition(document);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    protected void registerBeanDefinition(Document document) throws BeanException {
        Element root = document.getDocumentElement();
        processBeanDefinitions(root);
    }

    private void processBeanDefinitions(Element root) throws BeanException {
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item instanceof Element) {
                Element ele = (Element) item;
                processBeanDefinition(ele);
            }
        }
    }

    private void processBeanDefinition(Element ele) throws BeanException {
        String name = ele.getAttribute("name");
        System.out.println(name);
        String className = ele.getAttribute("class");
        System.out.println(className);
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperties(ele, beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name,beanDefinition);
    }

    private void processProperties(Element ele, BeanDefinition beanDefinition) {
        NodeList propertyList = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyList.getLength(); i++) {
            Node item = propertyList.item(i);
            if (item instanceof Element) {
                Element propertyEle = (Element) item;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
            }
        }
    }


}
