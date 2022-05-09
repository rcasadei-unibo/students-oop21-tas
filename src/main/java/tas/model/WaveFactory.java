package main.java.tas.model;

import java.util.List;

import main.java.tas.model.enemies.Enemy;

/**
 * An interface for
 */
public interface WaveFactory {
    
    /**
     * Generates a list with some enemies given the wave
     * @param wave of the game
     * @return list of enemies
     */
    List<Enemy> createEnemiesToBeSpawn(int wave);

}
