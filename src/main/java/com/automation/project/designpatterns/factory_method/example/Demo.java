package com.automation.project.designpatterns.factory_method.example;

import com.automation.project.designpatterns.factory_method.example.factory.Dialog;
import com.automation.project.designpatterns.factory_method.example.factory.HtmlDialog;
import com.automation.project.designpatterns.factory_method.example.factory.WindowsDialog;

/**
 * EN: Demo class. Everything comes together here.
 */
public class Demo {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    /**
     * EN: The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
    static void configure() {
        if (!System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    /**
     * EN: All of the client code should work with factories and products
     * through abstract interfaces. This way it does not care which factory it
     * works with and what kind of product it returns.
     */
    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
