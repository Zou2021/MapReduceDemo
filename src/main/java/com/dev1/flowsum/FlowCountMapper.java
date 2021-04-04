package com.dev1.flowsum;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author: 邹祥发
 * @date: 2021/3/29 16:23
 */
public class FlowCountMapper extends Mapper<LongWritable, Text, Text, FlowBean> {

    /**
     * 定义成员变量
     */

    private Text k = new Text();
    private FlowBean v = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        //获取一行
        String line = value.toString();
        //切割字段
        String[] split = line.split("\t");
        //封装对象，取出手机号码
        String phoneNum = split[1];
        /**
         * 取出上行流量和下行流量
         * 1	13736230513	192.196.100.1	www.dev1.com	2481	24681	200
         */
        long upFlow = Long.parseLong(split[split.length-3]);
        long downFlow = Long.parseLong(split[split.length-2]);

        k.set(phoneNum);
        v.setUpFlow(upFlow);
        v.setDownFlow(downFlow);

        //写出
        context.write(k,v);
    }
}
