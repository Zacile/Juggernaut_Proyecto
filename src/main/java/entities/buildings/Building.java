package entities.buildings;

import entities.city_stats.Stats;

import java.awt.*;

public abstract class Building {

   /* private BufferedImage background;
    private Assets textures;*/
    public int x,y;

    private Stats stats;

    public  Building(Stats stats, int x, int y) {
        // this.textures = textures;
        this.stats = stats;
        this.x = x;
        this.y = y;

    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    //********************************************************************************

    public abstract void  init();


    public abstract void update();

    public abstract void render(Graphics g);

    public abstract void add_Stats(Stats stats);

}
