package org.academiadecodigo.stringrays.frontbattle;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements Movables {

    private Position position;
    private String name;
    private int health = 100;
    private boolean destroyed;
    private Field field;
    private Direction direction;
    private Picture healthPicture;
    private Direction oldDirection;
    private String picturePath;

    public Player(String name, Position position, Field field, Direction direction, Picture healthPicture, String picturePath) {
        this.name = name;
        this.position = position;
        this.field = field;
        this.direction = direction;
        this.oldDirection = direction;
        this.healthPicture = healthPicture;
        this.picturePath = picturePath;
        healthPicture.draw();
    }

    public Position getPosition() {
        return position;
    }

    public Bullet attack() {

        //TODO REMOVE THIS CONDITION IF THE GAME OVER IS WELL DONE
        if (health > 0) {

            //TODO GET THE BULLET SIZE FIXED AND SHOOT RIGHT WITHOUT EXPANDING CANVAS
            switch (direction) {
                case UP:
                    return new Bullet(new Position((position.getX() + position.getMaxX()) / 2, position.getY() - 20, field, "img/bullet/upbullet1.png", 2), direction);
                case DOWN:
                    return new Bullet(new Position((position.getX() + position.getMaxX()) / 2, position.getMaxY(), field, "img/bullet/downbullet1.png", 2), direction);
                case LEFT:
                    return new Bullet(new Position(position.getX() - 20, (position.getY() + position.getMaxY()) / 2, field, "img/bullet/leftbullet1.png", 2), direction);
                case RIGHT:
                    return new Bullet(new Position(position.getMaxX(), (position.getY() + position.getMaxY()) / 2, field, "img/bullet/rightbullet1.png", 2), direction);
                case UPLEFT:
                    return new Bullet(new Position(position.getX() - 20, position.getY(), field, "img/bullet/upbullet1.png", 2), direction);
                case UPRIGHT:
                    return new Bullet(new Position(position.getMaxX() + 20, position.getY(), field, "img/bullet/upbullet1.png", 2), direction);
                case DOWNLEFT:
                    return new Bullet(new Position(position.getX(), position.getMaxY(), field, "img/bullet/downbullet1.png", 2), direction);
                case DOWNRIGHT:
                    return new Bullet(new Position(position.getMaxX(), position.getMaxY(), field, "img/bullet/downbullet1.png", 2), direction);
            }
        }
        return null;
    }

    public void setDirection(Direction direction) {

        this.direction = direction;

        if (direction != oldDirection) {
            switch (direction) {
                case UP:
                    position.getPicture().load(picturePath + "back/back1.png");
                    oldDirection = direction;
                    break;
                case DOWN:
                    position.getPicture().load(picturePath + "front/front1.png");
                    oldDirection = direction;
                    break;
                case LEFT:
                    position.getPicture().load(picturePath + "left/left1.png");
                    oldDirection = direction;
                    break;
                case RIGHT:
                    position.getPicture().load(picturePath + "right/right1.png");
                    oldDirection = direction;
                    break;
                case UPLEFT:
                    position.getPicture().load(picturePath + "back/back1.png");
                    oldDirection = direction;
                    break;
                case UPRIGHT:
                    position.getPicture().load(picturePath + "back/back1.png");
                    oldDirection = direction;
                    break;
                case DOWNLEFT:
                    position.getPicture().load(picturePath + "front/front1.png");
                    oldDirection = direction;
                    break;
                case DOWNRIGHT:
                    position.getPicture().load(picturePath + "front/front1.png");
                    oldDirection = direction;
                    break;
            }
        }
    }

    @Override
    public void move(Direction direction) {

        switch (direction) {
            case UP:
                position.moveUp();
                break;
            case DOWN:
                position.moveDown();
                break;
            case LEFT:
                position.moveLeft();
                break;
            case RIGHT:
                position.moveRight();
                break;
            case UPLEFT:
                position.moveUpLeft();
                break;
            case UPRIGHT:
                position.moveUpRight();
                break;
            case DOWNLEFT:
                position.moveDownLeft();
                break;
            case DOWNRIGHT:
                position.moveDownRight();
                break;
        }
    }

    public void hit(int damage) {
        health -= damage;

        switch (health) {
            case 90:
                healthPicture.load("img/health/90health.png");
                break;
            case 80:
                healthPicture.load("img/health/80health.png");
                break;
            case 70:
                healthPicture.load("img/health/70health.png");
                break;
            case 60:
                healthPicture.load("img/health/60health.png");
                break;
            case 50:
                healthPicture.load("img/health/50health.png");
                break;
            case 40:
                healthPicture.load("img/health/40health.png");
                break;
            case 30:
                healthPicture.load("img/health/30health.png");
                break;
            case 20:
                healthPicture.load("img/health/20health.png");
                break;
            case 10:
                healthPicture.load("img/health/10health.png");
                break;
            case 0:
                healthPicture.delete();
        }

        if (health <= 0) {
            position.hide();
            destroyed = true;
        }
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}
