package com.dev1.flowsum;

import lombok.Data;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author: 邹祥发
 * @date: 2021/3/29 16:24
 * 1.实现Writable接口
 */
@Data
public class FlowBean implements Writable {
    /**
     * upFlow 上行流量
     * downFlow 下行流量
     * sumFlow 总流量
     */
    private long upFlow;
    private long downFlow;
    private long sumFlow;

    /**
     * 2.反序列化时，需要反射调用空参构造函数，所以必须有
     */
    public FlowBean() {
        super();
    }

    public FlowBean(long upFlow, long downFlow) {
        super();
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.sumFlow = upFlow + downFlow;
    }

    /**
     * 3.写序列化方法
     */
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(upFlow);
        out.writeLong(downFlow);
        out.writeLong(sumFlow);
    }

    /**
     * 4.反序列化方法
     * 5.反序列化方法读顺序必须和写序列化方法的写顺序必须一致
     */
    @Override
    public void readFields(DataInput in) throws IOException {
        this.upFlow  = in.readLong();
        this.downFlow = in.readLong();
        this.sumFlow = in.readLong();
    }

    /**
     * 6.编写toString方法，方便后续打印到文本
     */
    @Override
    public String toString() {
        return upFlow + "\t" + downFlow + "\t" + sumFlow;
    }
}
