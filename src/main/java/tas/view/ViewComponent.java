package main.java.tas.view;

import javax.swing.JPanel;

import main.java.tas.model.Entity;

public interface ViewComponent {
    
    void drawEntity(Entity entity);
    void addEntityLabel(Entity entity);
    void removeEntityLabel(Entity entity);

    JPanel getPanel();
    void setObserver();

}
