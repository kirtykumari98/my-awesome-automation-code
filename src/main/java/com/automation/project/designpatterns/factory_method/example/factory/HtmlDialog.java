package com.automation.project.designpatterns.factory_method.example.factory;

import com.automation.project.designpatterns.factory_method.example.buttons.Button;
import com.automation.project.designpatterns.factory_method.example.buttons.HtmlButton;

/**
 * EN: HTML Dialog will produce HTML buttons.
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
