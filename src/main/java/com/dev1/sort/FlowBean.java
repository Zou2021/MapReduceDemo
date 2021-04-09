package com.dev1.sort;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 流量数据需要写到分区（文件）中
 * 还需要进行排序，升序，降序
 * WritableComparable =  序列化 + 排序
 * @author 15654
 */
public class FlowBean implements WritableComparable<FlowBean> {
    private long upFlow;
    private long downFlow;
    private long sumFlow;

    @Override
    public String toString() {
        return  upFlow +
                "\t" + downFlow +
                "\t" + sumFlow ;
    }

    public long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(long upFlow) {
        this.upFlow = upFlow;
    }

    public long getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(long downFlow) {
        this.downFlow = downFlow;
    }

    public long getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(long sumFlow) {
        this.sumFlow = sumFlow;
    }

    @Override
    public int compareTo(FlowBean o) {
        //如果要求数据升序  前者减后者，否则 后者减前者
        return (int) (o.getSumFlow() - this.sumFlow);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(upFlow);
        dataOutput.writeLong(downFlow);
        dataOutput.writeLong(sumFlow);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        upFlow= dataInput.readLong();
        downFlow= dataInput.readLong();
        sumFlow= dataInput.readLong();
    }
}
