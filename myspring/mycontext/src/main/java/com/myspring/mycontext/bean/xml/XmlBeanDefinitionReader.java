package com.myspring.mycontext.bean.xml;

import com.myspring.mycontext.BeanReference;
import com.myspring.mycontext.bean.AbstractBeanDefinitionReader;
import com.myspring.mycontext.bean.BeanDefinition;
import com.myspring.mycontext.bean.PropertyValue;
import com.myspring.mycontext.exception.beanexception.BeanCreateExeception;
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
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    protected void registerBeanDefinition(Document document) {
        Element root = document.getDocumentElement();
        processBeanDefinitions(root);
    }

    private void processBeanDefinitions(Element root) {
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item instanceof Element) {
                Element ele = (Element) item;
                processBeanDefinition(ele);
            }
        }
    }

    private void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("id");
        String className = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperties(ele, beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name, beanDefinition);
    }

    private void processProperties(Element ele, BeanDefinition beanDefinition) {
        NodeList propertyList = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyList.getLength(); i++) {
            Node node = propertyList.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                if (value != null && value.length() > 0) {
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                } else {
                    String ref = propertyEle.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new BeanCreateExeception(name);
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                }


            }
        }
    }


}
