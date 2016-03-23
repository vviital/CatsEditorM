package by.grsu.cats.editor.beans;

/**
 * Created by vviital on 23.3.16.
 */
public class Collar {

    private long id;
    private String text;
    private String color;
    private CatBean catBean;

    public Collar() {

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

    public CatBean getCatBean() {
        return catBean;
    }

    public void setCatBean(CatBean catBean) {
        this.catBean = catBean;
    }
}
