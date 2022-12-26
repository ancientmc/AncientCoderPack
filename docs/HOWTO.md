## How to use ACP ##
It's recommended to download ACP from the releases tab; currently, it is still in development and has not been released yet.
If you want to download ACP from the "Code" button on GitHub, that's fine, but make sure to rename the parent folder of the 
project files to "AncientCoderPack", otherwise it will not work. 

Before doing anything, you need to download JDK 8 and JDK 17. ACP is built against Java 8, and the majority of its processes, including running Minecraft, 
are using that version. However, Enigma, the program used for parameter mapping, is built against Java 17, so you need 
that version as well.

There are a variety of different JDK vendors you can find that will suit your needs. Here are some links to Temurin 
provided by Eclipse Adoptium.

Java 8 https://adoptium.net/temurin/releases/?version=8
Java 17 https://adoptium.net/temurin/releases/?version=17

When importing ACP into your IDE, make sure you set your JDK version (both for your IDE and for Gradle) to Java 8. 
You can do this any time before running the setup task; the JDK version won’t necessarily affect the Gradle initialization, 
at least from the tests that have been done.

Gradle will initialize as soon as the project is imported. This shouldn’t take more than a minute or so. 
All it’s doing is downloading the ACP-Gradle jar, downloading the version JSON, and downloading the libraries into your classpath.

Once that’s done, you can run the “setup” task that’s ¾ of the way down in the build.gradle file, or in the Gradle task group window 
under “acp-run”. ACP will then begin to do its thing. This should, on average, take about a minute or two. Note that some errors 
will popup once it reaches the “decompileClassFiles” stage. This is not a bug, but rather just some warnings Quiltflower throws at you. Everything is still running.

After the process has been completed, the source code is ready to browse. To run the game, click the “runClient” task in the same “acp-run” group.

To reobfuscate the code, click the "reobf" jar in the "acp-reobf" task group. This will generate and reobfuscate the output jar file found in 
the "build/libs" directory. As a reminder, do not publish this jar without ensuring it's been sufficiently modified. 