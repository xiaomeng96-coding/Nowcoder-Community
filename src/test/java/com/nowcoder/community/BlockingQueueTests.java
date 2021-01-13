package com.nowcoder.community;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTests {

    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(10);  // 队列容量10
        new Thread(new Producer(queue)).start();  //  1个生产者
        new Thread(new Consumer(queue)).start();  //  3个消费者
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }

}

// 生产者线程
class Producer implements Runnable{
    // 阻塞队列
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue){  // 有参构造器
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i < 100; i++) {
                Thread.sleep(20);  // 生产间隔20ms
                queue.put(i);
                System.out.println(Thread.currentThread().getName() + "生产：" + queue.size());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

// 消费者线程
class Consumer implements Runnable{

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue){  // 有参构造器
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(new Random().nextInt(1000)); // 消费时间间隔
                queue.take();
                System.out.println(Thread.currentThread().getName() + "消费：" + queue.size());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
