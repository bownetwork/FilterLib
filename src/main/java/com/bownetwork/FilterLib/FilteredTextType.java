package com.bownetwork.FilterLib;

import java.util.List;

public class FilteredTextType {
    private boolean filtered;
    private List<TextFilterType> filterThatCaught;

    public FilteredTextType(boolean filtered, List<TextFilterType> filterThatCaught) {
        this.filterThatCaught = filterThatCaught;
        this.filtered = filtered;
    }
    public boolean getFilteredStatus() {
        return filtered;
    }
    public List<TextFilterType> getFiltersThatCaught() {
        return filterThatCaught;
    }
}
