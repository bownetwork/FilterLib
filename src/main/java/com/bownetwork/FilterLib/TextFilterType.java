package com.bownetwork.FilterLib;

public class TextFilterType {
    private String regex;
    private String command;
    private String bypassPermission;

    public TextFilterType(String command, String regex, String bypassPermission) {
        this.command = command;
        this.regex = regex;
        this.bypassPermission = bypassPermission;
    }
    public String getCommand() {
        return command;
    }
    public String getRegex() {
        return regex;
    }
    public String getBypassPermission() {
        return bypassPermission;
    }

    void registerFilter() {
        FilterText.registerFilter(this);
    }
}