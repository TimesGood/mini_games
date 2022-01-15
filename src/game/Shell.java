package game;

import util.GameUtil;

import java.awt.*;

public class Shell extends GameObject{
    double degree;//随机子弹的角度
    boolean xAdd = true;
    boolean yAdd = true;

    @Override
    public void drawMySelf(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.yellow);
        g.fillOval(x,y,width,height);//绘制实心炮弹
        //炮弹沿不同方向飞出
        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);
        if(y >= GameUtil.FRAME_HEIGHT - height || y <= 32) {
            degree = -degree;
        }if(x >= GameUtil.FRAME_WIDTH - width || x <= 8) {
            degree = Math.PI-degree;
        }
        g.setColor(color);
    }
    public Shell(Image img, int x, int y, int speed, int width, int height) {
        degree = Math.random()*Math.PI*2;//生成360度的随机角度
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }
}
