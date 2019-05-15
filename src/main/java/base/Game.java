package base;

import base.States.GameState;
import base.States.State;
import gfx.Assets;
import gfx.Display;

import java.awt.*;

public class Game implements Runnable {


    private Thread thread;
    private boolean running;

    private Display display;
    private int width, height;
    private String title;

    private Graphics g;

    int x;
    //States

    private State gameState;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    //initialize before the game loop
    private void init() {

        display = new Display(title, width, height);
        Assets.init();
        gameState = new GameState(this);
        State.setState(gameState);
    }

    //update all the variables before rendering again
    private void update() {
        if (State.getState()!=null)
            State.getState().update();
    }

    //render all the graphics once all the variables has been updated
    private void render() {

        g = display.getCanvas().getGraphics();
        //Clear Screen
        g.clearRect(0,100,width,height);
        //Draw here
        if (State.getState()!=null)
            State.getState().render(g);
        //End drawing
        g.dispose();
    }

    public void run() {
        init();

        //Game loop timer variables
        long nanosec = 1000000000;
        int fps = 60;
        double timePerUpdate = nanosec/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long ticks = 0;
        //Game loop
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;
            timer+= now - lastTime;
            lastTime = now;

            if (delta>=1){
                update();
                render();
                ticks++;
                delta--;
            }
            if (timer >= nanosec){
                System.out.println(ticks);
                ticks = 0;
                timer = 0;

            }
        }

        stop();
    }

    public synchronized void start() {

        if (running == true)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {

        if (running == false)
            return;

        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //GETTERS AND SETTERS

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}