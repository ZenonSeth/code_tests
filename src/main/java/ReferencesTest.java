import kotlin.Pair;

import java.lang.ref.*;


/**
 * Initial testing of how different references in Java work.
 * In short, this test implies that:
 *
 * 1) Soft references don't get cleared on GC. They (probably) only get cleared when the JVM reaches the max allowed memory size for this process
 * 2) Weak and Phantom references both get cleared by GC. The difference being that Phantom references don't provide access to the object
 *
 */

public class ReferencesTest {

    private static class Wrapper {
        public final String value;
        public Wrapper(String val) {
            value = val;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize called on " + value);
        }
    }

    public static void main(String[] args) {
        Pair<PhantomReference<Wrapper>, Thread> phantomRef = phantomRef();
        Pair<SoftReference<Wrapper>, Thread> softR = softRef();
        Pair<WeakReference<Wrapper>, Thread> weakR = weakRef();


        try {
            System.out.println("\nWaiting 2 seconds before forcing GC...");
            Thread.sleep(2_000);

            //System.gc();
            allocateInts();

            System.out.println(phantomRef);
            System.out.println(softR);
            System.out.println(weakR);
            System.out.println("\n");
//            phantomRef.getSecond().join();
//            softR.getSecond().join();
//            weakR.getSecond().join();

            Thread.sleep(2_000);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }

    private static void allocateInts() {
        for (int i = 0; i < 4_000_000; i++) {
            if (new Integer(i).toString().equals("234")) System.out.println("\n>\n");
        }
    }

    static Pair<PhantomReference<Wrapper>, Thread> phantomRef() {
        final ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        Wrapper intObj = new Wrapper("phantom");
        PhantomReference<Wrapper> ref = new PhantomReference<>(intObj, refQueue);

        Thread thread = new Thread(() -> {
            printWhenObjIsFree(refQueue, "phantom reference", true);
        });
        thread.start();

        System.out.println("ptantom intObj = " + intObj);

        return new Pair<>(null, thread);
    }

    static Pair<SoftReference<Wrapper>, Thread> softRef() {
        final ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        Wrapper intObj = new Wrapper("soft");
        SoftReference<Wrapper> ref = new SoftReference<>(intObj, refQueue);

        Thread thread = new Thread(() -> {
            printWhenObjIsFree(refQueue, "soft reference", false);
        });
        thread.start();

        System.out.println("soft intObj = " + intObj);

        return new Pair<>(ref, thread);
    }

    static Pair<WeakReference<Wrapper>, Thread> weakRef() {
        final ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        Wrapper intObj = new Wrapper("weak");
        WeakReference<Wrapper> ref = new WeakReference<>(intObj, refQueue);

        Thread thread = new Thread(() -> {
            printWhenObjIsFree(refQueue, "weak reference", false);
        });
        thread.start();

        System.out.println("weak intObj = " + intObj);

        return new Pair<>(ref, thread);
    }

    static void printWhenObjIsFree(ReferenceQueue<?> queue, String name, boolean poll) {
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
