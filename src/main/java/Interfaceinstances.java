import java.util.HashSet;
import java.util.Set;

public class Interfaceinstances {

    public static class Widget {

        public interface Listener {
            void onClick(Widget w);
        }

        public final Set<Listener> listeners = new HashSet<>();

        public void addListener(Listener a) {
            listeners.add(a);
        }

        public void removeListener(Listener a) {
            listeners.remove(a);
        }

        public void simulateClick() {
            for(Listener l : listeners) {
                l.onClick(this);
            }
        }

    }
}
