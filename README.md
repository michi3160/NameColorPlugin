# ChatNameColorPlugin
- This is a plugin to change the color of the name in the chat box of Minecraft!
- NameColorPlugin - Chat Name Color Customizer for Spigot or Paper 1.21.x 
###  Overview 
- NameColorPlugin is a lightweight Minecraft plugin for Spigot 1.21.x that allows players to customize the color of their names in chat. It provides
- Player-controlled name color changes using /namecolor Default name colors based on 
- groups (using LuckPerms or a simple config fallback) 
- Automatic saving of settings, saved even after server restarts
- Works with or without LuckPerms. Easy to set up, simple to use!
- Requires Java 17 or higher
- Integrated with LuckPerms (optional, for group colors)

### Features
- Players can change their own name color using /namecolor
- Admins can change other players' name colors
- Default colors based on LuckPerms groups (or fallback to config.yml if no LuckPerms)
- Only the player’s name in chat is colored — the message text stays default
- Saves player-specific colors in config.yml

## config.yml

```
use-luckperms-color: true >>Integrate with LuckPerms
groups:     >>Color settings for each group
  default: '&7'
plaayers:　    >>Color settings for each player
 <player UUID>: §b
playerGroups:     >>Group settings for each player
 <playername>: §b
```
- You can only change the color with the command, but when changing it in config.yml, for example: §bIn this part: _§bIf you enter this, it will be displayed as _MichiJP (_ is white and MichiJP is light blue).
- Uses standard Minecraft color codes (&0 - &f).
