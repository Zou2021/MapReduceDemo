package com.dev1.flowsum;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author: 邹祥发
 * @date: 2021/3/30 16:25
 */
public class FlowCountReducer extends Reducer<Text,FlowBean,Text,FlowBean> {
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        long sum_upFlow = 0;
        long sum_downFlow = 0;

        //遍历bean，将上行流量和下行流量累加
        for (FlowBean flowBean:values){
            sum_upFlow += flowBean.getUpFlow();
            sum_downFlow += flowBean.getDownFlow();
        }

        //封装对象
        FlowBean resultBean = new FlowBean(sum_upFlow, sum_downFlow);

        //写出
        context.write(key,resultBean);
    }
}
