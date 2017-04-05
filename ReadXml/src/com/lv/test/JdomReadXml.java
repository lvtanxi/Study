package com.lv.test;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Date: 2017-04-05
 * Time: 15:58
 * Description:JDom解析xml
 */
public class JdomReadXml {
    public static void main(String[] args) {
        //创建SAXBuilder对象
        SAXBuilder saxBuilder = new SAXBuilder();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader=null;
        try {
            //创建一个输入流，加载xml
            inputStream = new FileInputStream("ReadXml/books.xml");
            //这样做可以解决乱码的问题
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            //通过SAXBuilder的build方法，把输入流加载到通过SAXBuilder的build方法中
            Document document = saxBuilder.build(inputStreamReader);
            //通过Document获取根节点
            Element rootElement = document.getRootElement();
            readXml(rootElement);
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (null != inputStreamReader)
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private static void readXml(Element element) {
        //获取节点的子节点
        List<Element> childrens = element.getChildren();
        for (Element children : childrens) {
            //获取所有属性
            List<Attribute> attributes = children.getAttributes();
            for (Attribute attribute : attributes) {
                //获取属性名称以及属性值
                System.out.println(attribute.getName()+"的属性值是:"+attribute.getValue());
            }
            //获取节点名称与节点值
            if(attributes.size()==0)
                System.out.println(children.getName()+"的值是："+children.getValue());
            readXml(children);
        }
    }

}
