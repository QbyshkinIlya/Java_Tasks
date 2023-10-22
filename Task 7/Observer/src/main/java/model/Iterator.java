package model;

public interface Iterator {
    public boolean hasNext();
    public Object next();
    public Object preview();
    boolean hasPreview();
    public int getCurrent();
}