package by.grsu.cats.editor.beans;

/**
 * Created by vviital on 23.3.16.
 */
public class Collar {

    private long id;
    private String text;
    private String color;
    private Cat cat;

    public Collar() {

    }

    public Collar(long id, String text, String color, Cat cat) {
        this.id = id;
        this.text = text;
        this.color = color;
        this.cat = cat;
        cat.setCollar(this);
    }

    public Collar(String text, String color, Cat cat) {
        this.text = text;
        this.color = color;
        this.cat = cat;
        cat.setCollar(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        builder.append("\tid = " + id);
        builder.append("\ttext = " + text);
        builder.append("\tcolor = " + color);
        builder.append(" }\t");
        return builder.toString();
    }
}
