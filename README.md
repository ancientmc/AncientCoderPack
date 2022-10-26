THIS CURRENTLY DOES NOT WORK. Several components are being rewritten.

The Retro Coder Pack aims to create a buildable gradle that allows users to view decompile source
code from older Minecraft versions. Currently, the only version being worked on is Alpha 1.2.6. It is inspired
by the Mod Coder Pack (MCP), a now-defunct tool that allowed users to view Minecraft's source code for mod development.
I'm hoping this project will do the same and encourage mod-development of older MC versions, and generally act as an educational
tool for people to learn about the history of Minecraft.

I originally created this project directly including and using files from the Mod Coder Pack version 2.5, but due to MCP's license 
I have been moving away from these in favor of more modern tools. RCP does use some tools developed by 
both OceanLabs (RetroGuard) and Forge (ForgeFlower), but these are Maven dependencies that are publicly available for others.

RCP will be using MCP mappings, however, especially for older versions. I intend to modify and add on to them though. Earlier MCP
mappings are especially incomplete. I may even try to create new mappings from scratch, although this is unlikely. The mappings can
be viewed in the RetroGuard script (a1.2.6.rgs). This is a version of MCP-2.5's mapping file that has been modified using
SRGerator, a program that I created. 

I am also using McAssetExtractor, a program that extracts runtime assets from Mojang's servers. This program was created by 
GitHub user rmheuer, but has been modified by me for the RCP process.

Stay tuned for a full release.
