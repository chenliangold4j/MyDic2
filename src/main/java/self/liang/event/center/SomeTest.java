package self.liang.event.center;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SomeTest {

   public static     ConcurrentHashMap<Integer,String> integerStringConcurrentHashMap = new ConcurrentHashMap<>();

   public static void keepRemove() throws InterruptedException {
       //用entrySet。。就算遍历的时候被删除。。可以遍历。。遍历不到删除的值
       //用keySet去取的话。值就没有了。。但是也不会报错
       //如果是希望遍历的时候被删除也能响应就用entrySet。。反之则用keySet然后get
       for (Map.Entry<Integer, String> entry : integerStringConcurrentHashMap.entrySet()) {
           long time = System.currentTimeMillis();
           Thread.sleep(100);
           integerStringConcurrentHashMap.remove(entry.getKey());
           System.out.println("size:"+integerStringConcurrentHashMap.size());
           System.out.println("time:"+(System.currentTimeMillis() - time));
       }
   }

   public static void keepIterator() throws InterruptedException {
       //当用entrySet进行删除时。。这边遍历的是同一个。。会缺少一些被删除的key的输出
       for (Map.Entry<Integer, String> entry : integerStringConcurrentHashMap.entrySet()) {
           Thread.sleep(200);
           System.out.println(entry.getKey());
       }
   }


    public static void main(String[] args) throws InterruptedException {
        for(int i = 0;i<100;i++){
            integerStringConcurrentHashMap.put(i,"test"+i);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SomeTest.keepIterator();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SomeTest. keepRemove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(3000000);
    }

}
