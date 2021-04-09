package com.dev1.flowsum;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author: 邹祥发
 * @date: 2021/4/9 08:43
 */
public class ProvincePartitioner extends Partitioner<Text,FlowBean> {
 @Override
 public int getPartition(Text text, FlowBean flowBean, int i) {
  //获取电话号码的前三位
  String phone = text.toString().substring(0,3);

  int partition = 4;

  //判断是哪个省
  if ("136".equals(phone)) {
   partition = 0;
  }else if ("137".equals(phone)) {
   partition = 1;
  }else if ("138".equals(phone)) {
   partition = 2;
  }else if ("139".equals(phone)) {
   partition = 3;
  }
  return partition;
 }
}
