package com.automation.project.designpatterns.factory_method.example.factory;

import com.automation.project.designpatterns.factory_method.example.buttons.Button;
import com.automation.project.designpatterns.factory_method.example.buttons.WindowsButton;


/**
 * EN: Windows Dialog will produce Windows buttons.
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
