## How To use Ancient Coder Pack (ACP) ##
Thank you for downloading Ancient Coder Pack! You are using Beta 0.3.0.

### Requirements ###
- Java 21

The Temurin version of OpenJDK 21 can be found on Eclipse Adoptium's [website](https://adoptium.net/temurin/releases/?version=21).

### Initial setup ###
When you either a) use any ACP command on a CLI, or b) open up ACP in an IDE for the first time, ACP will install:
- ACP-Gradle, the plugin required to decompile the game, and its dependencies.
- Configuration files for decompilation. This includes mappings and patch files.
- Minecraft JSON files, libraries, and assets.

These files should not need to be redownloaded unless they get deleted or moved. ACP attempts to re-download them every time
Gradle is reloaded.

### Decompilation (Vanilla) ###
To decompile Minecraft, go into either your CLI or wherever your IDE stores Gradle tasks, and run the `decompile` task.

This should only take a minute or two, depending on your computer, on the version selected, and if the initial setup hasn't happened.

The source files are located in "src/main/java/". Resources are located in "src/main/resources".

### Decompilation (ModLoader) ###
ACP supports Risugami's ModLoader, the predecessor to Minecraft Forge, for some versions of Minecraft. 
If you want to decompile Minecraft with the ModLoader pre-installed, do the following:

- If you already have decompiled the game, run the `clean` task.
- Run the `downloadModLoader` Gradle task. This downloads a LZMA file containing the ModLoader classes as binary patches.
- Then run the `decompile` task as normal.

Two classes are installed into the "net/minecraft/src" package: ModLoader.java, the core loading class, and BaseMod.java, which is 
the base file you need to extend your ModLoader mod from. 

If you want an example mod for Alpha 1.2.6 (as well as some documentation), check out [AncientMC's Ruby Mod](https://github.com/ancientmc/Alpha-Ruby-Mod).
Note that this version of ModLoader is quite limited in its functionality. 

### Running Minecraft ###
Use the `runClient` Gradle task to run a local instance of the Minecraft client. Save data and other files are stored in the "run/" folder.

### Recompilation and Distribution ###
To distribute your mod, run the Gradle task `buildMod`. This runs all the necessary steps to reobfuscate, recompile,
and package your modded classes into two archives (ZIP and TAR/GZIP) for you to share.

Installing these files in a JAR outside the ACP environment may vary depending on your launcher, but generally it will involve moving those class files
into the JAR using an archive explorer (this is how mod installation was done back in the day!). Remember if you use ModLoader (or any other library) you will need to install it separately.

The ZIP and GZIP archives will be located in the "build/modding/archive/{modname}" directory.

This task also generates two types of patches for you to distribute. 
- Binary patches are generated in the "build/modding/patches/bin" archive. These let you share your mod as an LZMA archive file
containing binary patches that can be applied to Minecraft's JAR, using the [BinaryPatcher tool](https://github.com/neoforged/InstallerTools/tree/main/binarypatcher).
This is good for people who want to make libraries that can be used in the ACP decompilation process. Putting the LZMAs in the "cfg/modpatches/" directory and running
the `decompile` task will apply them to the decompiled Minecraft source code.
- This task also generates DIFF patches containing the changes between Minecraft's vanilla code and your modifications. This is helpful to show off your changes to Minecraft's codebase
on a VCS repository like on GitHub, without sharing Minecraft's .java files directly (doing this is against AncientMC's license).

### Cleaning the Workspace ###
If you want to re-run the decompile task, run Gradle's `clean` task to clear the workspace of generated files. 
This *will* delete your mod files, so make sure to back them up! You probably shouldn't need to do this unless you mess with some of the backup
files in the "build/modding/" path, which you should avoid doing anyway.

### Switching Minecraft Versions ###
ACP currently has no easy, built-in way to cleanly switch the Minecraft version you're working with. The best thing to do is 
back up your repository to avoid data loss, close any Java processes, and delete the "build/", "cfg/", "run/", and "src/" directories.
Then change the `minecraft_version` field in the gradle.properties file and refresh to download data files for that version.