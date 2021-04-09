package com.dev1.sort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * MR只对 key进行排序
 * @author 15654
 */
public class FlowSumSortMapper extends Mapper<LongWritable,Text,FlowBean, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //13736230513	2481	24681	27162
        String line = value.toString();
        String[] arr = line.split("\t");

        FlowBean k = new FlowBean();
        //设置上行流量
        k.setUpFlow(Long.parseLong(arr[1]));
        //设置下行流量
        k.setDownFlow(Long.parseLong(arr[2]));
        //设置总行流量
        k.setSumFlow(Long.parseLong(arr[3]));
        Text v = new Text();
        //设置手机号
        v.set(arr[0]);
        //不管是写map，还是reduce目标就是 write方法的两个参数
        context.write(k,v);
        //2481	24681	27162 13736230513
    }
}
