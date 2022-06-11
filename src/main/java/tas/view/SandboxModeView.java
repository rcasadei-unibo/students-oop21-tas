package main.java.tas.view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.java.tas.controller.SandboxModeController;
import main.java.tas.controller.SceneController;
import main.java.tas.model.MenuModel;

public class SandboxModeView  {
	
	private JPanel rootPanel = new JPanel(new BorderLayout());
	private JButton finishButton = new JButton("DONE");
	private JPanel gamePanel = new JPanel(new GridBagLayout());
	private SquarePanel gameBoard = new SquarePanel();
    
    public SandboxModeView(MenuModel theModel){
    	
    	
		this.gameBoard.setBgImage("bgImage");
		this.gamePanel.add(this.gameBoard);
    	this.rootPanel.add(this.gamePanel, BorderLayout.CENTER);
    	this.rootPanel.add(this.finishButton, BorderLayout.SOUTH);
    	
    	
    }
    
	public JPanel getPanel() {
        return this.rootPanel;
    }
	
	public void setObserver(SceneController sandboxModeController) {
		this.gamePanel.addMouseListener(((SandboxModeController) sandboxModeController).getListener());;
    }
	
}