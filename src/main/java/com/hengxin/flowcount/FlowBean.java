package com.hengxin.flowcount;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author: zhouhengxin
 * @create: 2021-07-18 18:05
 **/
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FlowBean implements Writable {

    private long upFlow;  // 上行流量
    private long downFlow;  // 下行流量
    private long sumFlow;   // 总流量

    public FlowBean(long upFlow, long downFlow) {
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.sumFlow = upFlow + downFlow;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(upFlow);
        dataOutput.writeLong(downFlow);
        dataOutput.writeLong(sumFlow);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        upFlow = dataInput.readLong();
        downFlow = dataInput.readLong();
        sumFlow = dataInput.readLong();
    }

    // 输出打印的时候调用的是toString() 方法
    @Override
    public String toString() {
        return upFlow + "\t" + downFlow + "\t" + sumFlow;
    }
}
