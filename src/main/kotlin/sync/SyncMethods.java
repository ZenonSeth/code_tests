package sync;


public class SyncMethods {

    private int count = 0;

    public void inc() {
        //System.out.println(">> + enter");
        count = count + 1;
        //System.out.println("<< + exit");
    }

    public void dec() {
        //System.out.println(">> - enter");
        count = count - 1;
        //System.out.println("<< - exit");
    }

    public synchronized void sinc() {
        //System.out.println(">> +S enter");
        count = count + 1;
        //System.out.println("<< +S exit");
    }

    public synchronized void sdec() {
        //System.out.println(">> -S enter");
        count = count - 1;
        //System.out.println("<< -S exit");
    }


    public int getCount() {
        return count;
    }
}
