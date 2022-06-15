package main.java.tas.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.java.tas.controller.SceneActionObserver;

/**
 * Class that implements a {@link ViewComponent}.
 */
public class LevelSelectView implements ViewAction {
	
	private JPanel rootPanel = new JPanel(new GridLayout(0, 1, 5, 10));
	private JButton buttonList [];
	private int nLevels;
    
	/**
	 * Constructor that builds the view for the level select menu.
	 * @param theModel the menu model
	 */
    public LevelSelectView(int nLevelsIn){
    	nLevels = nLevelsIn;
    	buttonList = new JButton [nLevels];
    	int counter = 0; 
    	for (JButton button : buttonList) {
    		counter++;
    		button = new JButton(Integer.toString(counter));
    		this.buttonList[counter - 1] = button;
    		this.rootPanel.add(button);
    	}
    }
    
    /**
     * 
     * @return the root panel
     */
	public JPanel getPanel() {
        return this.rootPanel;
    }
	
	@Override
	public void setActionObserver(SceneActionObserver levelSelectController) {
		for(int counter = 0; counter < nLevels; counter++) {
			buttonList[counter].addActionListener(levelSelectController.getActionListener());
		}
    }
}
