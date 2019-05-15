package entities.buildings;

import entities.city_stats.Stats;

public class Building_Manager {

    private static test_building test;

   // adding buildings

    public static test_building addTestBuilding(Stats stats, int x, int y){
        return new test_building(stats, x, y);
    }
}
