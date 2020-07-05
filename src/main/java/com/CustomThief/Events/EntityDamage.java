package com.CustomThief.Events;

import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EntityDamage implements Listener {
    private final ItemStack[] goldsack = {
            new ItemStack(Material.GOLDEN_HELMET, 1),
            new ItemStack(Material.GOLDEN_AXE, 1),
            new ItemStack(Material.GOLD_NUGGET, 16),
            new ItemStack(Material.GOLDEN_SWORD, 1),
            new ItemStack(Material.EXPERIENCE_BOTTLE, 1),
            new ItemStack(Material.GUARDIAN_SPAWN_EGG, 4),
            new ItemStack(Material.ENCHANTED_GOLDEN_APPLE),
    };

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Villager))
            return;
        if (event.getEntity().getCustomName() == null)
            return;
        if (!event.getEntity().getCustomName().contains("Thief"))
            return;

        Random r = new Random();
        event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),
                goldsack[r.nextInt(goldsack.length + 0) - 0]);

    }
}
