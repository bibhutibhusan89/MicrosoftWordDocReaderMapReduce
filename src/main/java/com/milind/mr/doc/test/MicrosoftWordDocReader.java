/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milind.mr.doc.test;

/**
 *
 * @author milind
 */
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class MicrosoftWordDocReader {

    public static void readDocFile(String fileName) {
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument doc = new HWPFDocument(fis);
            WordExtractor we = new WordExtractor(doc);
            String[] paragraphs = we.getParagraphText();
            System.out.println("Total no of paragraph " + paragraphs.length);
            for (String para : paragraphs) {
                System.out.println(para.toString());
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readDocxFile(String fileName) {

        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            XWPFDocument document = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            System.out.println("Total no of paragraph " + paragraphs.size());
            for (XWPFParagraph para : paragraphs) {
                System.out.println(para.getText());
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String ext = FilenameUtils.getExtension("D:\\test.docx");
        System.out.println("extension : " + ext);
        if ("docx".equalsIgnoreCase(ext)) {
            readDocxFile("D:\\Test.docx");
        } else if ("doc".equalsIgnoreCase(ext)) {
            readDocFile("D:\\Test.doc");
        } else {
            System.out.println("INVALID FILE TYPE. ONLY .doc and .docx are permitted.");
        }
    }
}
