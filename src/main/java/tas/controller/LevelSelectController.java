package main.java.tas.controller;

import java.awt.event.ActionListener;

import main.java.tas.controller.lister.LevelSelectListener;
import main.java.tas.controller.observer.SceneActionObserver;
import main.java.tas.model.menu.MenuModel;
import main.java.tas.view.ViewAction;
import main.java.tas.view.scene.GenericScene;

/**
 * Class that creates a controller for the level select menu. Class that
 * implements {@link SceneActionObserver} and {@link SceneController}.
 */
public class LevelSelectController implements SceneActionObserver, SceneController {

	private LevelSelectListener listener;
	private GenericScene scene;
	private MenuModel model;

	/**
	 * Constructor that creates a menu controller for the level select menu.
	 * 
	 * @param sceneIn  the level select scene
	 * @param theModel the menu model
	 */
	public LevelSelectController(GenericScene sceneIn, MenuModel theModel) {
		scene = sceneIn;
		scene.setObserver(this);
		this.listener = new LevelSelectListener(((ViewAction) this.scene.getView()));
		this.model = theModel;
	}

	/**
	 * 
	 * @return the menu model
	 */
	public MenuModel getModel() {
		return this.model;
	}

	/** {@inheritDoc} */
	@Override
	public void nextTick() {
		if (this.listener.checkUpdate()) {
			this.model.setCurrentLevel(listener.getCommand());
			this.model.setMainScene(2);
			listener.resetUpdate();
		}

	}

	/**
	 * 
	 * @return the listener
	 */
	@Override
	public ActionListener getActionListener() {
		return this.listener;
	}

}
