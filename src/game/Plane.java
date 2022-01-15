package game;

import util.GameUtil;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{
    boolean left = false,up = false,right,down;
    public boolean live = true;
    @Override
    public void drawMySelf(Graphics g) {
        if(!live) return;
        if(left && !(x < 0)) {
            x -= speed;
        }
        if(right && !(x > GameUtil.FRAME_WIDTH-width)){
            x += speed;
        }
        if(up && !(y < 0)) {
            y -= speed;
        }
        if(down && !(y > GameUtil.FRAME_HEIGHT-height)){
            y += speed;
        }
        super.drawMySelf(g);
    }

    public Plane(Image img, int x, int y, int speed) {
        super(img, x, y, speed);
    }

    public void addDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
        }
    }
    public void minusDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
        }
    }
}
