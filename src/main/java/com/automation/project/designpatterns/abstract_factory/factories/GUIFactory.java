package com.automation.project.designpatterns.abstract_factory.factories;

import com.automation.project.designpatterns.abstract_factory.checkboxes.Checkbox;
import com.automation.project.designpatterns.abstract_factory.buttons.Button;
import com.automation.project.designpatterns.abstract_factory.textarea.TextArea;

/**
 * EN: Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
    TextArea createTextArea();
}
