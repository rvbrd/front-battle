package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position {

    private int x;
    private int y;
    private Field field;
    private Picture picture;
    private Rectangle rectangle;
    private int distance;

    public Position(int x, int y, Field field, String path, int distance) {
        this.distance = distance;
        this.x = x;
        this.y = y;
        this.field = field;
        picture = new Picture(x, y, path);
        rectangle = new Rectangle(picture.getX(), picture.getY(), picture.getWidth(), picture.getHeight());
        rectangle.draw();


    }

    public void show() {
        picture.draw();
    }

    public void hide() {
        rectangle.delete();
        picture.delete();
    }

    public void moveUp() {
        if (picture.getY() > Field.PADDING) {
            picture.translate(0, -distance);
            rectangle.translate(0, -distance);
        }
    }

    public void moveDown() {
        if (picture.getMaxY() < field.getHeight() + Field.PADDING) {
            picture.translate(0, distance);
            rectangle.translate(0, distance);
        }
    }

    public void moveLeft() {
        if (picture.getX() > Field.PADDING) {
            picture.translate(-distance, 0);
            rectangle.translate(-distance, 0);
        }
    }

    public void moveRight() {
        if (picture.getMaxX() < field.getWidth() + Field.PADDING) {
            picture.translate(distance, 0);
            rectangle.translate(distance, 0);
        }
    }

    public int getX() {
        return picture.getX();
    }

    public int getY() {
        return picture.getY();
    }

    public int getMaxX() {
        return picture.getMaxX();
    }

    public int getMaxY() {
        return picture.getMaxY();
    }

    public boolean equals(Position position) {
        return this.x == position.getX() && this.y == position.getY();
    }
}
