package xyz.joscodes.disablerespawnanchors;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.joscodes.disablerespawnanchors.events.RespawnAnchorExplosion;

public class DisableRespawnAnchors extends JavaPlugin implements Listener {

	private boolean disableExplosions;

	@Override
	public void onEnable() {
		// Load configuration values
		saveDefaultConfig();
		disableExplosions = getConfig().getBoolean("disable-explosions", true);

		// Register event listener
		getServer().getPluginManager().registerEvents(new RespawnAnchorExplosion(), this);


	}
}
