package main.java.tas.view;

import java.awt.GridBagLayout;
import java.awt.Color;

import javax.swing.JPanel;

import main.java.tas.model.Entity;

/**
 * Class that implements a {@link ViewComponent}
 */
public class GameView implements ViewComponent {
    
    private final JPanel rootCanvas = new JPanel(new GridBagLayout());  //TODO: forse e' meglio creare anche un japanel piu piccola su cui si baseranno tutte le figure minori e tenere questa come bordo (es i video su yt)
    private final SquarePanel gameBoard = new SquarePanel();
    
    /**
     * Constructor that set up the component
     */
    public GameView() {
        this.rootCanvas.add(this.gameBoard);
        this.gameBoard.setLayout(null); //TODO: se metto null, funziona, ma e' una bad practice
        
        this.rootCanvas.setBackground(Color.BLACK);
        this.gameBoard.setBackground(Color.DARK_GRAY);
    }
    
    /** {@inheritDoc} */
    @Override
    public void drawEntity(Entity entity) {
        this.gameBoard.redrawEntity(entity, entity.getPosition());
    }
    
    /** {@inheritDoc} */
    @Override
    public void addEntityLabel(Entity entity) {
        this.gameBoard.addEntity(entity);
    }
    
    /** {@inheritDoc} */
    @Override
    public void removeEntityLabel(Entity entity) {
        this.gameBoard.removeEntity(entity);
    }
    
    /** {@inheritDoc} */
    @Override
    public JPanel getPanel() {
        return this.rootCanvas;
    }

    /** {@inheritDoc} */
    @Override
    public void setObserver() {
        // TODO Auto-generated method stub
        
    }

}
