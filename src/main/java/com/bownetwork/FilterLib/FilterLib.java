package com.bownetwork.FilterLib;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilterLib {
    public static void initialize() {
        FilterText.clearFilters();
        createFilterLibFolder();
        copyConfigFile();
        ConfigProcessor.run();
        System.out.println("FilterLib | A text filtering library by BowFun | Loaded successfully");
    }
    // Method to create the "FilterLib" folder in the "plugins" directory
    private static void createFilterLibFolder() {
        File pluginsFolder = new File("plugins");
        File filterLibFolder = new File(pluginsFolder, "FilterLib");

        if (!filterLibFolder.exists()) {
            boolean folderCreated = filterLibFolder.mkdirs();
            if (folderCreated) {
                System.out.println("FilterLib folder created successfully.");
            } else {
                System.err.println("Failed to create FilterLib folder.\nJoin our Discord for help with FilterLib @ https://discord.bownet.xyz.");
            }
        }
    }

    // Method to copy the "config.yml" file from resources to "FilterLib" folder
    private static void copyConfigFile() {
        File filterLibFolder = new File("plugins", "FilterLib");
        File configFile = new File(filterLibFolder, "config.yml");

        if (!configFile.exists()) {
            // Get the path of the "config.yml" in the resources folder
            File resourceConfigFile = new File("src/main/resources/config.yml");

            try {
                Files.copy(resourceConfigFile.toPath(), configFile.toPath());
                System.out.println("config.yml added to FilterLib folder.");
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Failed to copy config.yml to FilterLib folder.\nJoin our Discord for help with FilterLib @ https://discord.bownet.xyz.");
            }
        }
    }
}