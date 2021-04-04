package com.dev1.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author: 邹祥发
 * @date: 2021/3/28 19:44
 */
public class WordCountMapper extends Mapper<LongWritable, Text,Text, IntWritable> {
    private Text k = new Text();
    private IntWritable v = new IntWritable();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] lineWords = value.toString().split(" ");
        for (String word : lineWords){
            k.set(word);
            v.set(1);
            context.write(k,v);
        }
    }
}
