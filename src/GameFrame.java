import game.Plane;
import game.Shell;
import util.GameUtil;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Frame {
    private final Image background = GameUtil.getImage("images/background.png");
    private final Image plane_img = GameUtil.getImage("images/plane.png");
    private Plane plane = new Plane(plane_img,250,450,3);
    Shell[] shells = new Shell[50];
    /**初始化窗口*/
    public void initFrame(){
        this.setTitle("飞机大战");//标题
        this.setVisible(true);//窗口默认不可见，设置成可见
        this.setSize(500,500);//窗口大小
        this.setLocation(300,300);//设置窗口展开的位置
        //设置窗口监听，使点X时可以关闭
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        new PaintThread().start();
        this.addKeyListener(new KeyMonitor());

        for (int i = 0;i < shells.length;i++) {
            shells[i] = new Shell(null,250,250,3,5,5);
        }
    }

    //重写画笔，绘制图形
    @Override
    public void paint(Graphics g) {
        //背景
        g.drawImage(background,0,0,GameUtil.FRAME_WIDTH,GameUtil.FRAME_HEIGHT,null);
        //飞机
        plane.drawMySelf(g);
        //炮弹
        for (int i = 0;i < shells.length;i++) {
            if(shells[i] == null) break;
            shells[i].drawMySelf(g);
            boolean isTouch = shells[i].getRect().intersects(plane.getRect());
            if(isTouch) {
                System.out.println("你已经死亡");
                plane.live = false;
            }
        }
    }
    //重绘线程，死循环一直重绘
    class PaintThread extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //键盘控制
    class KeyMonitor extends KeyAdapter {

        //键盘按下
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        //键盘松开
        @Override
        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);
        }
    }
    //窗口会一直闪烁，使用双缓冲技术
    private Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = this.createImage(GameUtil.FRAME_WIDTH,GameUtil.FRAME_HEIGHT);
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage,0,0,null);
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.initFrame();
    }
}
