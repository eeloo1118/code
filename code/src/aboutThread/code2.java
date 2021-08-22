package aboutThread;
//多线程在并发环境中的正常执行顺序是随机无序的
class T1 extends Thread{
    @Override
    public void run(){
        System.out.println("Thread1");
    }
}
class T2 extends Thread{
    @Override
    public void run(){
        System.out.println("Thread2");
    }
}

class T3 extends Thread{
    @Override
    public void run(){
        System.out.println("Thread3");
    }
}

//join（）假设A线程去调用B线程的join()方法，那么只有等待B线程完全执行完毕，A线程才可以执行
public class code2 {
    public static void main(String args[]) throws  InterruptedException{
        Thread thread1= new Thread(new T1());
        Thread thread2= new Thread(new T2());
        Thread thread3= new Thread(new T3());
        thread1.start();
        thread1.join();  //阻塞调用该方法的线程（在这边即为主线程），直到当前线程运行完毕（当前线程是thread1）,调用该方法的线程才能够运行
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();

    }
}

//执行结果为
// Thread1
//Thread2
//Thread3
//有序
