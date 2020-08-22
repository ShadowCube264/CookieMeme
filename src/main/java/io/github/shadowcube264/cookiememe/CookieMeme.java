package io.github.shadowcube264.cookiememe;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class CookieMeme extends JavaPlugin {
  @Override
  public void onEnable() {
	  getLogger().info("Sponsored by a certain 2D platformer! You know which one ;)");
  }
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (cmd.getName().equalsIgnoreCase("hbtroll")) {
        if (args.length > 1) {
          sender.sendMessage("Too many arguments!");
          return false;
        }
        if (args.length < 1) {
            sender.sendMessage("Not enough arguments!");
            return false;
          }
  		Player target = (Bukkit.getServer().getPlayer(args[0]));
  		if (target == null) {
  		  sender.sendMessage(args[0] + " is not online!");
  		  return false;
  		} else {
  			String tellrawcmd = "tellraw " + target.getDisplayName() + " {\"text\":\"Herobrine joined the game\",\"color\":\"yellow\"}";
  			Bukkit.dispatchCommand(sender, tellrawcmd);
  			return true;
  		}
      } else if (cmd.getName().equalsIgnoreCase("yeetusfeetus")) {
    	  if (sender instanceof Player) {
    	    Player player = (Player) sender;
    	    Bukkit.dispatchCommand(player, "give @s stick{display:{Name:'{\"text\":\"The Yeeter\",\"color\":\"gold\",\"bold\":true,\"underlined\":true}'},Enchantments:[{id:\"minecraft:knockback\",lvl:10s}]} 1");
    	    Bukkit.dispatchCommand(player, "tellraw @s {\"text\":\"YEET!\",\"color\":\"gold\",\"bold\":true}");
    	    return true;
    	  } else {
    	      sender.sendMessage("You must be a player!");
    	      return false;
    	  }
      } else if (cmd.getName().equalsIgnoreCase("unicorn")) {
          if (args.length > 1) {
            sender.sendMessage("Too many arguments!");
            return false;
          }
          if (args.length < 1) {
            sender.sendMessage("Not enough arguments!");
            return false;
          }
          Player target = (Bukkit.getServer().getPlayer(args[0]));
          if (target == null) {
            sender.sendMessage(args[0] + " is not online!");
        	return false;
          } else {
        	  String unicorncmd = "replaceitem entity " + target.getDisplayName() + " armor.head end_rod{display:{Name:'{\"text\":\"UNICORN HORN\",\"color\":\"light_purple\",\"bold\":true,\"underlined\":true}'}} 1";
        	  Bukkit.dispatchCommand(sender, unicorncmd);
        	  return true;
          }
      }
      return false;
  }
}
