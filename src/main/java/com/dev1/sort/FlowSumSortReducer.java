package com.dev1.sort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * reduce读map的数据是FlowBean,Text
 * reduce写是Text,FlowBean
 * @author 15654
 */
public class FlowSumSortReducer extends Reducer<FlowBean, Text,Text,FlowBean> {
    @Override
    protected void reduce(FlowBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        for(Text  text :values){
            Text k = text;
            FlowBean v = key;
            context.write(k,v);
        }
    }
}
