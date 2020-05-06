package com.example.xuebi.util;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

// 定时任务，每个月1号吧所有的库存存进盘点表
@Component
public class MyRunable implements Runnable {
    private AtomicInteger atomicInteger = null;
    private Random random = null;
    public MyRunable() {
        atomicInteger = new AtomicInteger(0);
        random = new Random();
    }


    @Override
    public void run() {
        try {
            int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            if (day == 1){
                //执行保存当前库存的操作。
                System.out.println("保存");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
