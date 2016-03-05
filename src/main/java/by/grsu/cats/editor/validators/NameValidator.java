package by.grsu.cats.editor.validators;

/**
 * Created by vviital on 5.3.16.
 */
public class NameValidator implements Validator {
    public boolean validate(String s) {
        boolean ok = true;
        if (s == null || s.isEmpty() || s.length() > 10) ok = false;
        return ok;
    }
}
