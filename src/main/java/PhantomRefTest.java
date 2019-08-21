import kotlin.Pair;

import java.lang.ref.*;


/**
 *
 */

public class PhantomRefTest {

    private static class Wrapper {
        @Override
        protected void finalize() {
            System.out.println("finalize called");
        }
    }

    public static void main(String[] args) {
        Pair<Reference<Wrapper>, Thread> phantomRef = phantomRef();
        try {
            System.out.println("\nWaiting 2 seconds before forcing GC...");
            Thread.sleep(2_000);

            //System.gc();
            allocateInts();
            System.out.println("\nGC forced");

            System.out.println("phantom ref pair was " + phantomRef);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }

    // 4_000_000 seems to cause no adding the object to the queue, yet finalize gets called. 8_000_000 causes both
    private static void allocateInts() {
        for (int i = 0; i < 4_000_000; i++) {
            if (new Integer(i).toString().equals("234")) System.out.println("\n>\n");
        }
    }

    static Pair<Reference<Wrapper>, Thread> phantomRef() {
        final ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        Wrapper intObj = new Wrapper();
        Reference<Wrapper> ref = new PhantomReference<>(intObj, refQueue);

        Thread thread = new Thread(() -> {
            printWhenObjIsPutInQueue(refQueue, "phantom reference", true);
        });
        thread.start();

        System.out.println("ptantom intObj = " + intObj);

        return new Pair<>(ref, thread);
    }

    static void printWhenObjIsPutInQueue(ReferenceQueue<?> queue, String name, boolean poll) {
        System.out.println("enter checking for " + name);
        try {
            if (poll) {
                while (true) {
                    Reference<?> aref = queue.poll();
                    if (aref != null) {
                        System.out.println("queue poll was non-null, name +  aref =  " +
                                "" + aref);
                        break;
                    }
                    Thread.sleep(250);
                }
            } else {
                queue.remove();
            }
        } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("Object freed from " + name + " queue");
    }

}
