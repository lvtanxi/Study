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
        try {
            //创建DocumentBuilder对象
            DocumentBuilder builder = dbf.newDocumentBuilder();
            //通过DocumentBuilder的parse加载xml文件
            Document document = builder.parse("ReadXml/books.xml");
            //根据标签名获取标签
            NodeList nodeList = document.getElementsByTagName("book");
            int length = nodeList.getLength();
            System.out.println("一共有"+length+"本书");
            //这是不知道属性的情况下完成
            readNode(nodeList);
            //知道属性的情况
      /*      Element element;
            for (int i = 0; i < length; i++) {
                element= (Element) nodeList.item(i);
                System.out.println("id的属性值是："+element.getAttribute("id"));
            }*/

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
        Node attrItem;
        for (int i = 0; i < length; i++) {
            node = nodeList.item(i);
            //区分出text类型的node一集element类型的node
            if(node.getNodeType()!=Node.ELEMENT_NODE)
                continue;
            //获取节点属性
            nodeAttributes = node.getAttributes();
            //这里需要注意getNodeValue不是自己的nodeValue而是第一个子节点的nodeValue，还要注意与getTextContent的区别
            System.out.println(node.getNodeName() + ">>" + node.getFirstChild().getNodeValue());
            if (nodeAttributes != null) {
                //遍历属性
                int nodeAttributesLength = nodeAttributes.getLength();
                for (int j = 0; j < nodeAttributesLength; j++) {
                    //获取某一个属性
                    attrItem = nodeAttributes.item(j);
                    System.out.println(attrItem.getNodeName() + ":" + attrItem.getNodeValue());
                }
            }
            //递归
            readNode(node.getChildNodes());
        }
    }

}
