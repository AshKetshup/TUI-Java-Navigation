package com.ashketshup.Landmark.UIElements;

import com.ashketshup.Landmark.Interfaces.Foo;
import com.ashketshup.Landmark.TUI.Input;
import com.ashketshup.Landmark.TUI.Output;

/**
 * The type Component.
 * A new input on a Form.
 */
public class Component implements Foo {
    private final boolean hidden;
    private final boolean required;
    private final String prompt;
    private String answer = "";

    /**
     * Instantiates a new Component.
     *
     * @param prompt   the prompt
     * @param hidden   the hidden
     * @param required the required
     */
    public Component(String prompt, boolean hidden, boolean required) {
        this.required = required;
        this.hidden = hidden;
        this.prompt = prompt;
    }

    /**
     * Sets answer.
     *
     * @param newAnswer the new answer
     */
    public void setAnswer(String newAnswer) { this.answer = newAnswer; }

    @Override
    public void apply() {
        this.answer = hidden ? Input.readHidden(prompt) : Input.readString(prompt);
    }

    @Override
    public String toString() {
        String printableAnswer = hidden ? Output.hiddenLn(answer) : answer;

        return prompt + " > " + printableAnswer;
    }
}