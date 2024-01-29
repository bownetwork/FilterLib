# FilterLib
 A simple Java library for standardized text filtering, designed for Minecraft plugins.
 Note that the documentation is written for Bukkit/Spigot/Paper plugins, but has worked in BungeeCord/Waterfall plugins with some changes.
 In theory, this should work for all Java projects.

# Setup Guide
To use FilterLib in your plugins, use the following steps. Note that this guide is for Gradle.
1. Add the [shadow](https://github.com/johnrengelman/shadow) plugin to your build.gradle.
2. Download the JAR file for FilterLib and put it in a standard directory.
3. Add this line to your build.gradle dependencies: ```implementation files('/full/path/to//FilterLib-1.0-SNAPSHOT.jar')```.
4. Import com.bownetwork.FilterLib.FilterLib into your main class.
5. Add this line to your onEnable method: ```FilterLib.initialize()```.
6. Add the Example Filter Code to your main class.
7. In any class or method where you want to filter text, instance main and use the filtering method provided in the example code. 
8. Run ./gradlew(.bat) shadowJar to build
9. Put your new JAR file onto a Minecraft server and reboot it.
10. Finally, check console and make sure your plugin mentions during loading that FilterLib has started.

## Example Filter Code
A simple method that gives all of FilterLib's features to the plugin.
**NOTE: This template code is for a Spigot plugin.**
This filters with regex provided in the config.
Also, it takes into account the bypass permission and the filtered command.
```
// FilterLib example filtering method
// Make sure to import these:
import com.bownetwork.FilterLib.FilterLib;
import com.bownetwork.FilterLib.FilterText;
import com.bownetwork.FilterLib.FilteredTextType;
import com.bownetwork.FilterLib.TextFilterType;
import org.bukkit.entity.Player;
// and follow the rest of the setup guide.

public boolean filterMessages(String valueToCheck, Player sendingPlayer) {
    // false returned means no issues
    // true means the message has been filtered.
    FilteredTextType filteredTextData = FilterText.filter(valueToCheck);
    boolean status = false;
    for (TextFilterType allCaught : filteredTextData.getFiltersThatCaught()) {
        if (!sendingPlayer.hasPermission(allCaught.getBypassPermission())) {
            getServer().getScheduler().runTask(this, () -> {
                String runningCommand = allCaught.getCommand();
                runningCommand = runningCommand.replace("%player%", sendingPlayer.getName());
                getServer().dispatchCommand(getServer().getConsoleSender(), runningCommand);
            });
            status = true;
        }
    }
    return status;
}```
