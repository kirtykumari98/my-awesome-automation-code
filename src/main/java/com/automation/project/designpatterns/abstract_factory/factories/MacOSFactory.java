package com.automation.project.designpatterns.abstract_factory.factories;

import com.automation.project.designpatterns.abstract_factory.checkboxes.Checkbox;
import com.automation.project.designpatterns.abstract_factory.checkboxes.MacOSCheckbox;
import com.automation.project.designpatterns.abstract_factory.buttons.Button;
import com.automation.project.designpatterns.abstract_factory.buttons.MacOSButton;
import com.automation.project.designpatterns.abstract_factory.textarea.MacTextArea;
import com.automation.project.designpatterns.abstract_factory.textarea.TextArea;

/**
 * EN: Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.

 */
public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }

    @Override
    public TextArea createTextArea() {
        return new MacTextArea();
    }


}
