package com.bownetwork.FilterLib;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterText {
    private static List<TextFilterType> filterTypes = new ArrayList<>();
    public static FilteredTextType filter(String textToFilter) {
        // TODO: Write the filter code
        boolean detected = false;
        List<TextFilterType> allCaughtFilters = new ArrayList<>();
        for (TextFilterType aFilter : filterTypes) {
            Pattern pattern = Pattern.compile(aFilter.getRegex(), Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(textToFilter);
            int wordsCaught = 0;
            while (matcher.find()) {
                wordsCaught = wordsCaught + 1;
                if (wordsCaught == 1) {
                    allCaughtFilters.add(aFilter);
                }
                detected = true;
            }
        }
        return new FilteredTextType(detected, allCaughtFilters);
    }
    static void registerFilter(TextFilterType filter) {
        filterTypes.add(filter);
    }
    static void clearFilters() {
        filterTypes.clear();
    }
}