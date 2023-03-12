package xyz.joscodes.disablerespawnanchors;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DisableRespawnAnchors extends JavaPlugin implements Listener {

	private boolean disableExplosions;

	@Override
	public void onEnable() {
		saveDefaultConfig();
		reloadConfig();
		getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void reloadConfig() {
		super.reloadConfig();
		FileConfiguration config = getConfig();
		disableExplosions = config.getBoolean("disable-respawn-anchor-explosions", true);
	}

	@EventHandler
	public void onBlockExplode(BlockExplodeEvent event) {
		if (disableExplosions) {
			for (Block block : event.blockList()) {
				if (block.getType() == Material.RESPAWN_ANCHOR) {
					event.setCancelled(true);
					break;
				}
			}
		}
	}
}
