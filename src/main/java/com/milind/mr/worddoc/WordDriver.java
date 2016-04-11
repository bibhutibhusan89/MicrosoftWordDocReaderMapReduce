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
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordDriver {

    private static Logger logger = LoggerFactory.getLogger(WordDriver.class);

    /**
     * Main entry point for the example.
     *
     * @param args arguments
     * @throws Exception when something goes wrong
     */
    public static void main(String[] args) throws Exception {
        logger.info("Driver started");

        Job job = new Job();
        job.setJarByClass(WordDriver.class);
        job.setJobName("Excel Record Reader");

        job.setMapperClass(WordMapper.class);
        job.setNumReduceTasks(0);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setInputFormatClass(WordInputFormat.class);

        job.waitForCompletion(true);
    }

}
