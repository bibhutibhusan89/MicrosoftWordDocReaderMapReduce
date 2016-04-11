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

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordMapper extends
        Mapper<LongWritable, Text, Text, Text> {

    private static Logger LOG = LoggerFactory.getLogger(WordMapper.class);

    /**
     * Excel Spreadsheet is supplied in string form to the mapper. We are simply
     * emitting them for viewing on HDFS.
     */
    public void map(LongWritable key, Text value, Context context)
            throws InterruptedException, IOException {
        String line = value.toString();

        context.write(new Text(line), null);
        LOG.info("Map processing finished");

    }
}
