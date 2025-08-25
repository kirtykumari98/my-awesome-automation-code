package com.automation.project.designpatterns.abstract_factory.app;


import com.automation.project.designpatterns.abstract_factory.checkboxes.Checkbox;
import com.automation.project.designpatterns.abstract_factory.factories.GUIFactory;
import com.automation.project.designpatterns.abstract_factory.buttons.Button;

/**
 * EN: Factory users don't care which concrete factory they use since they work
 * with factories and products through abstract interfaces.
 *
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
