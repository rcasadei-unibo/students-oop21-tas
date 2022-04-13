package main.java.tas.tower;

import main.java.tas.model.enemies.Enemy;
import main.java.tas.utils.Position;

public class BasicTower extends AbstractBasicTower {
	private Enemy target = null; // TODO cambiare con gli opzionali
	
	BasicTower(Position pos, int damage, int radius, int delay) {
		super(pos, damage, radius, delay);
	}

	@Override
	protected void attack() {
		this.target.dealDamage(this.getDamage());
	}

	@Override
	protected void setTarget(final Enemy e) {
		this.target = e;
	}

	@Override
	public void compute() {
		// TODO Auto-generated method stub

	}

}
