## Branch Archival Notice ##
This branch is an archive of how Retro Coder Pack (RCP) was before it got converted into a gradle plugin in December 2022.

Before this change, RCP tasks were directly integrated into the build.gradle file. While this system was fine initially, 
it's become increasingly messy and undesirable for RCP.

This branch is downloadable, although if you want to use it, you need to rename the extracted folder to "RetroCoderPack".
It should work by executing the "runRCP" task.

This branch is only built for Alpha 1.2.6, the original version RCP was built on. It won't be built on any other version.

If there's critical bugs, I may make some minor tweaks to this version to ensure it's at least functional, but it won't receive any updates beyond that.

-Mason

**What is the Retro Coder Pack?**

The Retro Coder Pack (RCP) aims to create a buildable gradle that allows users to view decompile source
code from older Minecraft versions. Currently, the only version being worked on is Alpha 1.2.6. It is inspired
by the Mod Coder Pack (MCP), a now-defunct tool that allowed users to view Minecraft's source code for mod development.
I'm hoping this project will do the same and encourage mod-development of older MC versions, and generally act as an educational
tool for people to learn about the history of Minecraft.

**What tools are used for RCP?**

I originally created this project directly including and using files from the Mod Coder Pack version 2.5, but due to MCP's license 
and the age of the tools I have been moving away from these in favor of more modern tools. RCP does use some tools developed by 
OceanLabs, MinecraftForge, and FabricMC, but these are Maven dependencies that are publicly available for others.
The only tool directly included is McAssetExtractor, a forked tool originally developed by GitHub user rhmeuer.

A toolchain text file wll be included to go more in depth about everything, but here's a brief rundown of the tools 
and what they do:

- RetroGuard by OceanLabs/MCP: Deobfuscation of classes, methods, and fields. [GitHub](https://github.com/ModCoderPack/Retroguard).
- MCInjector by OceanLabs/MCP: Adding exceptions for methods. [GitHub](https://github.com/ModCoderPack/MCInjector).
- Enigma by cuchaz, fork by FabricMC: Parameter name deobfuscation. [GitHub](https://github.com/FabricMC/Enigma).
- Fernflower by JetBrains, fork by MinecraftForge: Decompilation, Local variable naming. [GitHub](https://github.com/MinecraftForge/FernFlower).
- DiffPatch by CBProject, fork by MinecraftForge: Patching source files to eliminate errors. [GitHub](https://github.com/MinecraftForge/DiffPatch).
- McAssetExtractor by rhmeuer, fork by me: extracting the run-time assets (not the ones from the client JAR) from Mojang's servers 
into the workspace. [Original GitHub](https://github.com/rmheuer/McAssetExtractor). [Forked GitHub](https://github.com/moist-mason/McAssetExtractor).

**What mappings does RCP use?**

For methods, classes, and fields, RCP uses SRG files. The SRG file for Minecraft Alpha 1.2.6 is generated via a tool
developed by me called [SRGConfig](https://github.com/moist-mason/SRGConfig). SRGConfig aims to convert the original RGS files
found in the earliest MCP versions, albeit slightly modified, and converts them into SRG files, with custom names and everything.
The mappings are taken from numerous MCP versions, written by the original MCP devs. Take a look at the SRGConfig 
repository for more information. 

For parameters, RCP uses Enigma. Aside from an older version of MCInjector (that RCP doesn't use), Enigma is pretty much the only 
deobfuscator/bytecode editor, that I know of, that allows for direct editing of parameter names. Lack of options and Enigma's 
ease of use makes it the preferred choice. The parameter names are written by me, and are currently work in progress.

Stay tuned for a full release.
