package main.java.tas.controller.tower.factory;

import java.util.List;

import main.java.tas.controller.tower.builder.AttackType;
import main.java.tas.controller.tower.builder.TowerBuilder;
import main.java.tas.model.enemy.Enemy;
import main.java.tas.model.tower.Tower;
import main.java.tas.utils.Position;

/**
 * An interface that is specified to build archer tower
 */
public interface ArcherFactory {

	/**
	 * Return an archer with only one target possible, and upgradable
	 * 
	 * @param pos       Position of the tower
	 * @param enemyList List of all enemy in the map
	 * @return an archer with only one target possible, and upgradable
	 */
	static public Tower basicArcher(final Position pos, final List<Enemy> enemyList) {
		return new TowerBuilder(pos, DefaultTowersUtils.JSONOBJECTMAP.get(DefaultTowers.BASICARCHER), enemyList)
				.setUpgradable(true)
				.maxLevel(25).startUpgradeCost(1000).upgradeCost(x -> x + 20).upgradeDamage(x -> 15)
				.build();
	}

	/**
	 * Return an archer with two targets possible, and upgradable
	 * 
	 * @param pos       Position of the tower
	 * @param enemyList List of all enemy in the map
	 * @return an archer with two targets possible, and upgradable
	 */
	static public Tower biArcher(final Position pos, final List<Enemy> enemyList) {
		return new TowerBuilder(pos, DefaultTowersUtils.JSONOBJECTMAP.get(DefaultTowers.BIARCHER), enemyList)
				.attackType(AttackType.MULTIPLE)
				.maximumTarget(2)
				.setUpgradable(true)
				.maxLevel(25)
				.startUpgradeCost(1000)
				.upgradeCost(x -> x + 25).upgradeDamage(x -> 20).build();
	}

	/**
	 * Return an archer with three targets possible, and upgradable
	 * 
	 * @param pos       Position of the tower
	 * @param enemyList List of all enemy in the map
	 * @return an archer with three targets possible, and upgradable
	 */
	static public Tower triArcher(final Position pos, final List<Enemy> enemyList) {
		return new TowerBuilder(pos, DefaultTowersUtils.JSONOBJECTMAP.get(DefaultTowers.TRIARCHER), enemyList)
				.attackType(AttackType.MULTIPLE).maximumTarget(3).setUpgradable(true).maxLevel(25)
				.startUpgradeCost(1000).upgradeCost(x -> x + 30).upgradeDamage(x -> 25).build();
	}

	/**
	 * Return an archer with four targets possible, and upgradable
	 * 
	 * @param pos       Position of the tower
	 * @param enemyList List of all enemy in the map
	 * @return an archer with four targets possible, and upgradable
	 */
	static public Tower quadArcher(final Position pos, final List<Enemy> enemyList) {
		return new TowerBuilder(pos, DefaultTowersUtils.JSONOBJECTMAP.get(DefaultTowers.QUADARCHER), enemyList)
				.attackType(AttackType.MULTIPLE).maximumTarget(4).setUpgradable(true).maxLevel(25)
				.startUpgradeCost(1000).upgradeCost(x -> x + 35).upgradeDamage(x -> 30).build();
	}
}
