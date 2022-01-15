package game;

import java.awt.*;

/**
 * 游戏物体的根类
 */
public class GameObject {
    Image img;//物体图片
    int x,y;//物体坐标
    int speed;//物体速度
    int width,height;//物体宽高

    public GameObject() {
    }

    public GameObject(Image img) {
        this.img = img;
        if(img != null) {
            this.width = img.getWidth(null);
            this.height = img.getHeight(null);
        }
    }

    public GameObject(Image img, int x, int y) {
        this(img);
        this.x = x;
        this.y = y;
    }

    public GameObject(Image img, int x, int y, int speed) {
        this(img,x,y);
        this.speed = speed;
    }

    public GameObject(Image img, int x, int y, int speed, int width, int height) {
        this(img,x,y,speed);
        this.width = width;
        this.height = height;
    }

    public void drawMySelf(Graphics g){
        g.drawImage(img,x,y,width,height,null);
    }
    //返回自己占据对应的矩形
    public Rectangle getRect(){
        return new Rectangle(x,y,width,height);
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
