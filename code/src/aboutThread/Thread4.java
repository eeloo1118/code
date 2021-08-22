package aboutThread;

public class Thread4 {
    public static void main(String []args){
        final Thread4 demo= new Thread4();
        Thread t1= new Thread(demo::print1);
        Thread t2= new Thread(demo::print2);
        t1.start();
        t2.start();
    }

    public synchronized void print2(){
        for(int i=1;i<=100;i+=2){
            System.out.println(i);
            this.notify();
            try{
                this.wait();
                Thread.sleep(100);
            }catch (InterruptedException e){

            }
        }
    }

    public synchronized void print1(){
        for(int i=0;i<=100;i+=2){
            System.out.println(i);
            this.notify();
            try{
                this.wait();
                Thread.sleep(100);
            }catch (InterruptedException e){

            }
        }
    }


}
