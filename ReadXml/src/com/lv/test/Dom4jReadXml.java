package com.lv.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultAttribute;

import java.io.File;
import java.util.Iterator;

/**
 * Date: 2017-04-05
 * Time: 17:14
 * Description:Dom4j解析xml
 */
public class Dom4jReadXml {
    public static void main(String[] args) {
        //创建 SAXReader 对象
        SAXReader saxReader = new SAXReader();
        try {
            //通过SAXReader的read方法加载xml,获取Document
            Document document = saxReader.read(new File("ReadXml/books.xml"));
            //通过document获取根节点
            Element rootElement = document.getRootElement();
            readXml(rootElement);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void readXml(Element element) {
        //获取子节点迭代器
        Iterator iterator = element.elementIterator();
        while (iterator != null && iterator.hasNext()) {
            //获取子节点
            Element child = (Element) iterator.next();
            //获取属性
            Iterator attributeIterator = child.attributeIterator();
            while (attributeIterator.hasNext()){
                DefaultAttribute attribute = (DefaultAttribute) attributeIterator.next();
                System.out.println(attribute.getName()+"的属性值是:"+attribute.getValue());
            }
            if(child.attributeCount()==0)
                System.out.println(child.getName()+">>"+child.getTextTrim());
            readXml(child);
        }

    }

}
