package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GameUtil {
    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 500;
    private GameUtil(){}//构造器私有，防止外部创建
    public static Image getImage(String path) {
        Image img = null;
        //获取项目路径
        URL resource = GameUtil.class.getClassLoader().getResource(path);
        try {
            img = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
