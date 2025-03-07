package main.java.tas.model.tower;

import java.util.List;
import main.java.tas.model.enemy.Enemy;
import main.java.tas.utils.Position;

/**
 * This abstract class model a simple tower with some basic methods useful for
 * different implementations
 * 
 */
public abstract class AbstractBasicTower implements Tower {
	private int damage;
	private final Position pos;
	private final int radius;
	private final int delay;
	private final int cost;
	private final String towerName;
	private final List<Enemy> visibleEnemyList;

	/**
	 * Constructor, protected
	 * 
	 * @param pos       Tower position
	 * @param damage    Tower damage
	 * @param radius    Tower radius, where it can attack enemies
	 * @param delay     Tower delay
	 * @param cost      Tower cost
	 * @param towerName Tower name
	 * @param enemyList List of all enemy in the map
	 */
	public AbstractBasicTower(final Position pos, final int damage, final int radius, final int delay,
			final int cost, final String towerName, final List<Enemy> enemyList) {
		this.damage = damage;
		this.pos = pos;
		this.radius = radius;
		this.delay = delay;
		this.cost = cost;
		this.towerName = towerName;
		this.visibleEnemyList = enemyList;
	}

	/**
	 * Return all the enemy present in the map
	 * 
	 * @return a copy of the list containing all enemy in the map
	 */
	protected List<Enemy> getVisibleEnemyList() {
		return List.copyOf(this.visibleEnemyList);
	}

	/**
	 * This function sleeps the current thread, depending from the defined field
	 * delay {@link: AbstractBasicTower#delay}
	 */
	protected void sleep() {
		try {
			Thread.sleep(this.getDelay());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deal damage to the target. It's up to the concrete class to choose the
	 * implementation of attack
	 */
	abstract protected void attack();

	/**
	 * Set's the target of this tower, It's up to the concrete class to choose the
	 * implementation of set target
	 * 
	 * @param e Enemy to be focused
	 */
	abstract protected void setTarget(final Enemy e);

	/**
	 * Increase the damage of the tower, useful in order to upgrade it
	 * 
	 * @param amount Amount of damage that increase
	 */
	protected void increaseDamage(final int amount) {
		this.damage += amount;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDelay() {
		return this.delay;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getCost() {
		return this.cost;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDamage() {
		return this.damage;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Position getPos() {
		return this.pos;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getRadius() {
		return this.radius;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTowerName() {
		return this.towerName;
	}
}
