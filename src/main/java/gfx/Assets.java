package gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 10, height=10;
    public static BufferedImage house, building, land;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/test.png"));
        house = sheet.crop(0,0,width, height);

    }

}
