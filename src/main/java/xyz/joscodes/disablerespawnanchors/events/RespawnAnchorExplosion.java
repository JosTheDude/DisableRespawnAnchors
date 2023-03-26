package xyz.joscodes.disablerespawnanchors.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.data.type.RespawnAnchor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RespawnAnchorExplosion implements Listener {

	@EventHandler
	public static void onRightClickBlock(PlayerInteractEvent e) {

		Player player = e.getPlayer();
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;

		if (e.getClickedBlock() == null) return;

		RespawnAnchor anchor = (RespawnAnchor) e.getClickedBlock().getBlockData();

		if (e.getClickedBlock().getType() == Material.RESPAWN_ANCHOR) {

			if (anchor.getCharges() == 4) {

				e.setCancelled(true);

				if (player.hasPermission("disablerespawnanchors.notify")) {
					player.sendMessage(ChatColor.RED + "Respawn Anchors are disabled and cannot be exploded.");
				}
			}
		}
	}

}
