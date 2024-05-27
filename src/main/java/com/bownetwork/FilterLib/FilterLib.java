package com.bownetwork.FilterLib;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

<<<<<<< HEAD
    // Method to copy the "config.yml" file from resources to "FilterLib" folder
    private static void copyConfigFile() {
        File filterLibFolder = new File("plugins", "FilterLib");
        File configFile = new File(filterLibFolder, "config.yml");

        if (!configFile.exists()) {
            // Get the path of the "config.yml" in the resources folder
            InputStream configInputStream = FilterLib.class.getResourceAsStream("config.yml");
            Path destinationPath = Paths.get("plugins/FilterLib", "config.yml");
            try {
                Files.copy(configInputStream, destinationPath);
                System.out.println("config.yml added to FilterLib folder.");
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Failed to copy config.yml to FilterLib folder.\nJoin our Discord for help with FilterLib @ https://discord.bownet.xyz.");
=======
    // Method to copy the "filters.yml" file from resources to "FilterLib" folder
    private static void copyConfigFile() {
        File filterLibFolder = new File("plugins", "FilterLib");
        File configFile = new File(filterLibFolder, "filters.yml");

        if (!configFile.exists()) {
            // Get the path of the "filters.yml" in the resources folder
            InputStream configInputStream = FilterLib.class.getClassLoader().getResourceAsStream("filters.yml");
            Path destinationPath = Paths.get("plugins/FilterLib", "filters.yml");
            try {
                Files.copy(configInputStream, destinationPath);
                System.out.println("filters.yml added to FilterLib folder.");
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Failed to copy filters.yml to FilterLib folder.\nJoin our Discord for help with FilterLib @ https://discord.bownet.xyz.");
>>>>>>> f85b98d (Copied some code from old computer\nGot some old code off of my old SSD.)
            }
        }
    }
}