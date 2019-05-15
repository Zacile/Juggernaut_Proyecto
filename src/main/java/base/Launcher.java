package base;

public class Launcher {

    public static void main(String []args){
        Game game = new Game("game", 640, 480);
        //start the game loop
        game.start();
    }
}
