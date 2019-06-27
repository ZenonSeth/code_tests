import io.reactivex.Observable;
import io.reactivex.functions.Function;


public class RxRangeAndStartsWith {

    public static void main(String[] args) {
        Observable
                .range(1, 0)
                .map((Function<Integer, Object>) integer -> {
                    System.out.println(integer);
                    return integer;
                })
                .subscribe();

        Observable
                .range(1, 0)
                .startWith(0)
                .map((Function<Integer, Object>) integer -> {
                    System.out.println(integer);
                    return integer;
                })
                .subscribe();

    }
}
