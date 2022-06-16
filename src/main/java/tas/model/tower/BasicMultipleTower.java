package main.java.tas.model.tower;

import java.util.List;
import main.java.tas.model.enemy.Enemy;
import main.java.tas.utils.Position;

/**
 * This class is a basic implementation of AbstractMultipleTower this
 * BasicMultipleTower model a tower that attack the first maxTarget in the range
 */
public class BasicMultipleTower extends AbstractMultipleTower {

	/**
	 * Constructor, protected
	 * 
	 * @param pos       Tower position
	 * @param damage    Tower damage
	 * @param radius    Tower radius, where it can attack enemies
	 * @param delay     Tower delay
	 * @param cost      Tower cost
	 * @param imageName Tower image name
	 * @param enemyList List of all enemy in the map
	 * @param maxTarget Max number of target that this tower can handle at the time
	 */
	protected BasicMultipleTower(final Position pos, final int damage, final int radius, final int delay,
			final int cost, final String imageName, final List<Enemy> enemyList, final int maxTarget) {
		super(pos, damage, radius, delay, cost, imageName, enemyList, maxTarget);
	}

	/** {@inheritDoc} */
	@Override
	protected boolean isValidTarget(final Enemy e) {
		return Towers.isTargetInRange(e, this) && !this.isFull() && !this.contains(e);
	}

	/** {@inheritDoc} */
	@Override
	public void compute() throws InterruptedException {
		/*
		List<Enemy> toRemove = Towers.findAll(x->!Towers.isTargetInRange(x, this) || x.isDead(), this.getEnemyList());
		
		this.getEnemyList().removeAll(toRemove);
		*/
		Towers.findAll(x->!Towers.isTargetInRange(x, this) || x.isDead(),this.getEnemyList())
				.stream()
				.forEach(this::remove);
		
		if (!this.isFull()) {
			Towers.findAll(this::isValidTarget, this.getVisibleEnemyList())
					.stream()
					.limit(this.getMaxEnemy() - this.getEnemyList().size())
					.forEach(this::setTarget);
		}
		
		this.attack();
		Thread.sleep(this.getDelay());
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "BasicMultipleTower [getEnemyList()=" + getEnemyList() + ", getMaxEnemy()=" + getMaxEnemy()
				+ ", isFull()=" + isFull() + ", getDelay()=" + getDelay() + ", getCost()=" + getCost()
				+ ", getDamage()=" + getDamage() + ", getPos()=" + getPos() + ", getRadius()=" + getRadius()
				+ ", getTowerImageName()=" + getTowerImageName() + "]";
	}

}
