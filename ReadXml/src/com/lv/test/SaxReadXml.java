package com.lv.test;

import com.lv.model.Book;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Date: 2017-04-05
 * Time: 14:21
 * Description:SAX解析Xml
 */
public class SaxReadXml {

    public static void main(String[] args) {
        //获取SAXParserFactory的实例
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            //通过SAXParserFactory获取SAXParser
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse("ReadXml/books.xml", new SAXParserHander());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class SAXParserHander extends DefaultHandler {
        int bookIndex;
        Book mBook;
        String nodeName;
        private Class<? extends Book> bookClass;

        /**
         * xml的开始标签
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            //获取属性个数
            int length = attributes.getLength();
            if (length > 0) {
                mBook=new Book();
                bookClass = mBook.getClass();
                bookIndex++;
                System.out.println("开始解析第" + bookIndex + "本书");
           /*    //已经知道属性的名称这可以这样做
               String id = attributes.getValue("id");
               System.out.println("book的屬性值是："+id);*/
                for (int i = 0; i < length; i++) {
                    //获取属性名称与属性值
                    nodeName = attributes.getQName(i);
                    System.out.println(nodeName + " 的属性值是：" + attributes.getValue(nodeName));
                    setValue(nodeName, attributes.getValue(nodeName));
                }
            } else if (!"bookstore".equals(qName)) {
                nodeName = qName;
                System.out.print("节点名：" + qName);
            }

        }

        void setValue(String fieldName, String value) {// 属性
            try {
                Field field = bookClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(mBook, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.println(fieldName+" 属性未找到");
            }
        }

        /**
         * xml的结束标签
         */
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            //判断是否针对一本书已经遍历结束
            if ("book".endsWith(qName)) {
                System.out.println("解析完第" + bookIndex + "本书");
                System.out.println(mBook);
            }

        }


        /**
         * 解析开始
         */
        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            System.out.println("SAX解析开始");
        }

        /**
         * 解析结束
         */
        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
            System.out.println("SAX解析结束");
        }

        /**
         * 获取节点值
         */
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            String value = new String(ch, start, length);
            if (!"".equals(value.trim())) {
                System.out.println(" 节点值是：" + value);
                setValue(nodeName, value);
            }
        }
    }
}
