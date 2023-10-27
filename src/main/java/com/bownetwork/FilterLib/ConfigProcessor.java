package com.bownetwork.FilterLib;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ConfigProcessor {
    static List<TextFilterType> parseConfigFile() {
        Yaml yaml = new Yaml();

        List<TextFilterType> textFilterTypes = new ArrayList<>();

        // Define the path to the "config.yml" file
        String configFilePath = "plugins/FilterLib/config.yml";

        File configFile = new File(configFilePath);

        if (configFile.exists()) {
            try (FileInputStream inputStream = new FileInputStream(configFile)) {
                // Parse the YAML file
                Map<String, Map<String, Object>> config = yaml.load(inputStream);

                if (config != null) {
                    // Iterate over the configuration data
                    for (Map.Entry<String, Map<String, Object>> entry : config.entrySet()) {
                        String key = entry.getKey();
                        Map<String, Object> values = entry.getValue();

                        // Extract the values
                        String command = (String) values.get("command");
                        String regex = (String) values.get("regex");
                        String bypassPermission = (String) values.get("bypass_permission");

                        // Create a new TextFilterType instance and add it to the list
                        TextFilterType filterType = new TextFilterType(command, regex, bypassPermission);
                        textFilterTypes.add(filterType);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("An error occurred while reading the FilterLib configuration file.\nJoin our Discord for help with FilterLib @ https://discord.bownet.xyz.");
            }
        } else {
            System.err.println("Configuration file not found at " + configFilePath);
        }

        return textFilterTypes;
    }

    static void run() {
        List<TextFilterType> filterTypes = parseConfigFile();

        // Now you have the list of TextFilterType instances
        for (TextFilterType filterType : filterTypes) {
            filterType.registerFilter();
        }
    }
}
