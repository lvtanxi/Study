package com.lv.test;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Date: 2017-04-01
 * Time: 16:00
 * Description:Dom 解析 xml
 */
public class DomReadXml {

    public static void main(String[] args) {
        //创建一个DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //创建一个DocumentBuilder的对象
        try {
            //创建DocumentBuilder对象
            DocumentBuilder builder = dbf.newDocumentBuilder();
            //通过DocumentBuilder的parse加载xml文件
            Document document = builder.parse("ReadXml/books.xml");
            //根据标签名获取标签
            NodeList nodeList = document.getElementsByTagName("book");
            readNode(nodeList);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void readNode(NodeList nodeList) {
        //遍历每一个获取到的节点
        if (nodeList == null)
            return;
        int length = nodeList.getLength();
        Node node;
        NamedNodeMap nodeAttributes;
        for (int i = 0; i < length; i++) {
            node = nodeList.item(i);
            //获取节点属性
            nodeAttributes = node.getAttributes();
            System.out.println(node.getNodeName() + ">>" + node.getNodeValue() );
            if (nodeAttributes != null) {
                //遍历属性
                int nodeAttributesLength = nodeAttributes.getLength();
                for (int j = 0; j < nodeAttributesLength; j++) {
                    //获取某一个属性
                    Node item = nodeAttributes.item(j);
                    System.out.println(item.getNodeName() + ":" + item.getNodeValue());
                }
            }
            readNode(node.getChildNodes());
        }
    }

}
