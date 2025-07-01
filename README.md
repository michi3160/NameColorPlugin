# NameColorPlugin
This is a plugin to change the color of the name in the chat box of Minecraft!
______________________________________________________________________________________________
🌈 NameColorPlugin - Chat Name Color Customizer for Spigot 1.21.x
📌 Overview
NameColorPlugin is a lightweight Minecraft plugin for Spigot 1.21.x that allows players to customize the color of their names in chat.
It provides:

✅ Player-controlled name color changes using /namecolor
✅ Default name colors based on groups (using LuckPerms or a simple config fallback)
✅ Persistent per-player color settings, saved even after server restarts

Works with or without LuckPerms. Easy to set up, simple to use!

🛠 Supported Versions
Minecraft 1.21.x (Spigot or Paper)

Requires Java 17 or higher

Supports LuckPerms (optional, for group colors)

✨ Features
Players can change their own name color using /namecolor

Admins can change other players' name colors

Default colors based on LuckPerms groups (or fallback to config.yml if no LuckPerms)

Only the player’s name in chat is colored — the message text stays default

Saves player-specific colors in players.yml

Permissions
Permission	Description	Default
namecolor.self	    | Allows players to change their own name color	true
namecolor.others	| Allows changing other players' name colors	op


config.yml

groups:
  default: '&7'
  admin: '&c'
  vip: '&b'

Matches LuckPerms group names.

Uses standard Minecraft color codes (&0 - &f).

If LuckPerms is not installed, these values still work based on config.

