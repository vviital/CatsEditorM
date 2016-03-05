package by.grsu.cats.editor.validators;

/**
 * Created by vviital on 5.3.16.
 */
public class ColorValidator implements Validator {
    public boolean validate(String s) {
        boolean ok = true;
        if (s == null) ok = false;
        else if (s.length() != 6) ok = false;
        else {
            try {
                int color = Integer.parseInt(s, 16);
            } catch (NumberFormatException e) {
                ok = false;
            }
        }
        return ok;
    }
}
