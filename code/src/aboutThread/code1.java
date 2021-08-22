package aboutThread;

class myThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println("Sub"+i);
    }
}

public class code1 {
    public static void main (String args[]){
        myThread mythread= new myThread();
        mythread.start();
        for(int i=0;i<10;i++)
            System.out.println("Main"+i);
    }

}
