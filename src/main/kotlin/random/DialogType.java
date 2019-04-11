package random;

import org.jetbrains.annotations.NotNull;

public abstract class DialogType {

    public int value1 = 0;
    public String title = null;
    @NotNull public String otherString;
    public Runnable callback = null;

    private DialogType( ) {  }

    // enum declaration - kidna

    public static class MyDialog extends DialogType {
        MyDialog(String title, Runnable callback) {
            this.title = title;
            this.callback = callback;
        }
    }

}
