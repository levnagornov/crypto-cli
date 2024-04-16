package org.example.menu;

import java.util.function.Supplier;

public class ResultableMenuItem<T> extends MenuItem {
    private final Supplier<T> command;
    private T result;

    public ResultableMenuItem(String title, Supplier<T> command) {
        super(title);
        this.command = command;
    }

    @Override
    public void execute() {
        System.out.println("*** " + getTitle() + " ***");
        result = command.get();
    }

    public T getResult(){
        return result;
    }
}
