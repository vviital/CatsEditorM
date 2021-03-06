package by.grsu.cats.editor.beans;

import by.grsu.cats.editor.validators.ColorValidator;
import by.grsu.cats.editor.validators.NameValidator;
import by.grsu.cats.editor.validators.Validator;

/**
 * Created by vviital on 5.3.16.
 */
public class Cat implements Cloneable {
    private long hash;

    private String name;
    private String color;
    private Collar collar;

    private Validator colorValidator = new ColorValidator();
    private Validator nameValidator = new NameValidator();

    private boolean isColorValid = true;
    private boolean isNameValid = true;

    public Cat() {
        init();
    }

    public Cat(long hash, String color, String name) {
        setHash(hash);
        setColor(color);
        setName(name);
    }

    public Cat(String color, String name) {
        setColor(color);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.isNameValid = nameValidator.validate(name);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        this.isColorValid = colorValidator.validate(color);
    }

    public boolean isColorValid() {
        return isColorValid;
    }

    public boolean isNameValid() {
        return isNameValid;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        builder.append("hash = " + this.hash);
        builder.append("\tname = " + this.name);
        builder.append("\tcolor = " + this.color);
        builder.append("\tisColorValid = " + this.isColorValid);
        builder.append("\tisNameValid = " + this.isNameValid);
        builder.append("\t" + this.collar.toString());
        builder.append(" }\n");
        return builder.toString();
    }

    private void init() {
        this.colorValidator = new ColorValidator();
        this.nameValidator = new NameValidator();
        this.isColorValid = false;
        this.isNameValid = false;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public boolean isValid() {
        return this.isColorValid() && this.isNameValid();
    }

    public Collar getCollar() {
        return collar;
    }

    public void setCollar(Collar collar) {
        this.collar = collar;
    }

    public Cat clone() {
        Cat cat = new Cat();
        cat.setColor(this.color);
        cat.setName(this.name);
        cat.setHash(this.hash);
        return cat;
    }
}
