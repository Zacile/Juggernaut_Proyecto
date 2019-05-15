package base.States;

import base.Game;
import entities.buildings.Building;
import entities.buildings.Building_Manager;
import entities.city_stats.Population;
import entities.city_stats.Stats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameState extends State{

    //game engine vars
    private Stats stats;
    private ArrayList<Building> buildings;
    private int x;



    //buttons and options vars

    private JLabel pop_num;
    private JLabel pgr_num;
    private JLabel pdr_num;
    private JButton b_addTest;


    public GameState(Game game){
        super(game);
        init();

    }

    public void init(){
        x = 0;
        Population pop = new Population(0,0,0,100);
        stats = new Stats(pop);
        pop_num = new JLabel();
        pgr_num = new JLabel();
        pdr_num = new JLabel();

        b_addTest = new JButton("Add Test Building");
        b_addTest.setBounds(50,10,95,30);
        b_addTest.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buildings.add(0, Building_Manager.addTestBuilding(stats, x, 100));
                x+=15;
                System.out.println("El nuevo valor de pgr es " + stats.getPopulation().getPgr());
            }
        });
        game.getDisplay().getCanvas().setLayout(new FlowLayout());
        game.getDisplay().getCanvas().add(b_addTest);
        game.getDisplay().getCanvas().add(pop_num);
        game.getDisplay().getCanvas().add(pgr_num);
        game.getDisplay().getCanvas().add(pdr_num);


        buildings = new ArrayList<Building>();


    }

    public void update() {
        pop_num.setText("Population: " + stats.getPopulation().getPopulation());
        pgr_num.setText("Population growth rate: " + stats.getPopulation().getPgr());
        pdr_num.setText("Population death rate: " + stats.getPopulation().getPmr());
        stats.getPopulation().update();
       // System.out.println(stats.getPopulation().getPopulation());
    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0,100,640,380);
        for (int i  =0; i<buildings.size(); i++)
            buildings.get(i).render(g);

        //g.drawImage(Assets.house, 0,0,null);
    }
}
