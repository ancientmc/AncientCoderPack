## How To use Ancient Coder Pack (ACP) ##
Thank you for downloading Ancient Coder Pack! You are using Beta 0.2.2.

### Requirements ###
- Java 8

The Temurin version of OpenJDK 8 (AKA 1.8) can be found on Eclipse Adoptium's [website](https://adoptium.net/temurin/releases/?version=8).

### Initial setup ###
When you either a) use any ACP command on a CLI, or b) open up ACP in an IDE for the first time, ACP will install:
- ACP-Gradle, the plugin required to decompile the game, and its dependencies.
- Configuration files for decompilation. This includes mappings and patch files.
- Minecraft JSON files, libraries, and assets.

These files should not need to be redownloaded unless they get deleted or moved. ACP attempts to re-download them every time
Gradle is reloaded.

### Decompilation (Vanilla) ###
To decompile Minecraft, go into either your CLI or wherever your IDE stores Gradle tasks, and run the `decompile` task.

This should only take a minute or two, depending on your computer and if the initial setup hasn't happened.

The source files are located in "src/main/java/net/minecraft/". Resources are located in "src/main/resources".

### Decompilation (ModLoader) ###
ACP supports Risugami's ModLoader, the predecessor to Minecraft Forge. If you want to decompile Minecraft with the ModLoader pre-installed,
do the following:

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
To easily get your modded class files into an archive, run the Gradle task `makeArchives`. This runs all the necessary steps to reobfuscate, recompile,
and package your modded classes into two archives (ZIP and TAR/GZIP) for you to share. 

Installing these files in a JAR outside the ACP environment may vary depending on your launcher, but generally it will involve moving those class files
into the JAR using an archive explorer (this is how mod installation was done back in the day!). Remember if you use ModLoader (or any other library) you will need to install it separately.

The ZIP and GZIP archives will be located in the "build/modding/archive/{modname}" directory.

### Making Patch Files ###
By default, Git ignores any Minecraft source files. You are not allowed to share them online, even if modified.

To share your modifications to Minecraft's source files, run the `makeDiffPatches` task in Gradle. This will make DiffPatches that show
the changes you've made that you can upload in a repository or other place online. You can find the packages in "build/modding/patches/diff".
You should ignore the "acp/" subdirectory.
