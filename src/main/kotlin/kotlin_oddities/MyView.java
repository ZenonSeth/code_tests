package kotlin_oddities;

import io.reactivex.annotations.NonNull;

import java.util.HashSet;
import java.util.Set;

public class MyView {

    Set<ClickListener> listenerMap = new HashSet<>();

    public interface ClickListener {
        void onClick();
    }

    void simulateOnClick() {
        for(ClickListener l : listenerMap) {
            l.onClick();
        }
    }

    void addOnClickListener(@NonNull ClickListener listener) {
        listenerMap.add(listener);
    }

    void removeClickListener(@NonNull ClickListener listener) {
        listenerMap.remove(listener);
    }
}
