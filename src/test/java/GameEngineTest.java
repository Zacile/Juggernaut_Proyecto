import static org.junit.jupiter.api.Assertions.*;

import base.Game;
import org.junit.jupiter.api.*;


public class GameEngineTest {

        public static Game gameEngine;

    @BeforeAll
    public static void setup() {
        gameEngine = new Game("GameEngine Test", 640, 480);
        gameEngine.start();
    }

    @Test
    public void test1(){
        assertTrue(gameEngine.isRunning());
    }
}
