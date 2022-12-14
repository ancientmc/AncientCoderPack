## How to use ACP ##
It's recommended to download ACP from the releases tab If you want to download ACP from the "Code" button on GitHub, that's fine, 
but make sure to rename the parent folder of the project files to "AncientCoderPack", otherwise it will not work. 

Before doing anything, you need to download JDK 8 and JDK 17. ACP is built against Java 8, and the majority of its processes, including running Minecraft, 
are using that version. However, Enigma, the program used for parameter mapping, is built against Java 17, so you need that version as well.

There are a variety of different JDK vendors you can find that will suit your needs. Here are some links to Temurin 
provided by Eclipse Adoptium.

Java 8: https://adoptium.net/temurin/releases/?version=8
Java 17: https://adoptium.net/temurin/releases/?version=17

You don't need to worry about what JDK you have set for your IDE and for Gradle; Most ACP tasks run regardless of either version,
and any ACP task that needs a specific Java version is already configured to call that version. Just make sure you have the versions 
listed above installed on your device (Gradle should auto-detect them). If you're unsure, run the "javaToolchains" task 
in the "help" group. This task lists the JDKs Gradle recognizes; if the versions you just installed are there, you're good to go.

Gradle will initialize as soon as the project is imported. This shouldn’t take more than a minute or so. 
All it’s doing is downloading the ACP-Gradle jar and its dependencies, downloading the version JSON, and downloading Minecraft's libraries into your classpath.

Once that’s done, you can run the “setup” task that’s ¾ of the way down in the build.gradle file, or in the Gradle task group window 
under “acp-run”. ACP will then begin to decompile the source code. This should, on average, take about a minute or two. The first time will take 
longer (but not by much), because it needs to install the external tools, such as RetroGuard and Enigma. Note that some errors 
will popup once it reaches the “decompileClassFiles” stage. This is not a bug, but rather just some warnings Quiltflower throws at you. Everything is still running.

After the process has been completed, the source code is ready to browse. To run the game, click the “runClient” task in the same “acp-run” group.

To reobfuscate the code, click the "reobf" jar in the "acp-reobf" task group. This will generate and reobfuscate the output jar file found in 
the "build/libs" directory. As a reminder, do not publish this jar without ensuring it's been sufficiently modified. 