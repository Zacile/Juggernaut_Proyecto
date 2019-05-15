package entities.buildings;

import entities.city_stats.Stats;

import java.awt.*;

public class test_building extends Building {


    public test_building(Stats stats, int x, int y) {
        super(stats, x, y);
        init();

    }

    public void init(){
        add_Stats(this.getStats());
    }

    public void update() {

    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x,y,10,10);
    }

    public void add_Stats(Stats stats) {
        stats.getPopulation().add_pgr(0.05);
    }
}
