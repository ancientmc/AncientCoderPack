## Ancient Coder Pack ##

See the How-To text file (HOWTO.md) located in the "docs" folder to get started with ACP.

### NOTE: Ancient Coder Pack (ACP) is not currently compatibile with Risugami's ModLoader or other loaders. Support will be coming in the near future. ###


**What is the Ancient Coder Pack?**

The Ancient Coder Pack (ACP) aims to create a buildable gradle that allows users to view decompile source
code from older Minecraft versions. Currently, the only version being worked on is Alpha 1.2.6. It is inspired
by the Mod Coder Pack (MCP), a now-defunct tool that allowed users to view Minecraft's source code for mod development.
I'm hoping this project will do the same and encourage mod-development of older MC versions, and generally act as an educational
tool for people to learn about the history of Minecraft.

**What tools are used for ACP?**

At first, ACP directly included and using files from the Mod Coder Pack version 2.5, but due to fears of MCP's license 
and the age of the tools they have been replaced by more modern and open-source tools. ACP does use some tools developed by 
OceanLabs, MinecraftForge, and FabricMC, but these are Maven dependencies that are publicly available for others.
The only tool directly included is McAssetExtractor, a forked tool originally developed by GitHub user rhmeuer.

A toolchain text file may be included to go more in depth about everything, but here's a brief rundown of the tools 
and what they do:

- RetroGuard by OceanLabs/MCP: Deobfuscation of classes, methods, and fields. [GitHub](https://github.com/ModCoderPack/Retroguard).
- MCInjector by OceanLabs/MCP: Adding exceptions for methods. [GitHub](https://github.com/ModCoderPack/MCInjector).
- Enigma by cuchaz, fork by FabricMC: Parameter name deobfuscation. [GitHub](https://github.com/FabricMC/Enigma).
- Fernflower by JetBrains, fork by MinecraftForge: Decompilation, Local variable naming. [GitHub](https://github.com/MinecraftForge/FernFlower).
- DiffPatch by CBProject, fork by MinecraftForge: Patching source files to eliminate errors. [GitHub](https://github.com/MinecraftForge/DiffPatch).
- McAssetExtractor by rhmeuer, fork by me: extracting the run-time assets (not the ones from the client JAR) from Mojang's servers 
into the workspace. [Original GitHub](https://github.com/rmheuer/McAssetExtractor). [Forked GitHub](https://github.com/moist-mason/McAssetExtractor).

**What mappings does ACP use?**

For methods, classes, and fields, ACP uses MCP names and SRG files. The SRG file for Minecraft Alpha 1.2.6 is generated via a tool
developed by AncientMC called [SRGConfig](https://github.com/moist-mason/SRGConfig). SRGConfig aims to convert the original RGS files
found in the earliest MCP versions, albeit slightly modified, and converts them into SRG files, with custom names and everything.
The mappings are taken from numerous MCP versions, written by the original MCP devs. Take a look at the SRGConfig 
repository for more information. 

For parameters, ACP uses Enigma. Aside from an older version of MCInjector (that ACP doesn't use), Enigma is pretty much the only 
deobfuscator/bytecode editor that allows for direct editing of parameter names. Lack of options and Enigma's 
ease of use makes it the preferred choice. The parameter names are written by AncientMC, although primarily based on names from MCP mappings, and are currently work in progress.