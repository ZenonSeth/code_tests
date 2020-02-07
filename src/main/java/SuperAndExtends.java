


public class SuperAndExtends {

    public interface Bin <T extends Number> {
        void chuck(T thing);
    }


    public static void main(String[] args) {

    }

    public void thing(Bin<Number> numberBin, Bin<Double> doubleBin) {
//        doubleBin = numberBin;
//        numberBin = doubleBin;
    }
}
