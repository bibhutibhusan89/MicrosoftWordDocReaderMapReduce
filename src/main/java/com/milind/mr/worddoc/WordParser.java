/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milind.mr.worddoc;

/**
 *
 * @author milind
 */
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class WordParser {

    private static final Log LOG = LogFactory.getLog(WordParser.class);
    private StringBuilder currentString = null;
    private long bytesRead = 0;

    public String parseExcelData(InputStream is) {
        try {
            HWPFDocument doc = new HWPFDocument(is);
            WordExtractor we = new WordExtractor(doc);
            String[] paragraphs = we.getParagraphText();
            currentString = new StringBuilder();
            for (String para : paragraphs) {
                currentString.append(para + "\n");
            }
            is.close();
        } catch (IOException e) {
            LOG.error("IO Exception : File not found " + e);
        }
        return currentString.toString();

    }

    public long getBytesRead() {
        return bytesRead;
    }

}
