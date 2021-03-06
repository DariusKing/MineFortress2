package com.uddernetworks.tf2.guns.custom.spy;

import com.uddernetworks.tf2.guns.GunObject;
import com.uddernetworks.tf2.guns.custom.Controller;
import org.bukkit.entity.Player;

public class Spy extends Controller {

    public Spy(GunObject gun, Player player, boolean held) {
        super(gun, player, held);
    }

    @Override
    public void sendStopNotify(Player player) {
        try {
            switch (getChildAbilities().get(0)) {
                case "watch":
                    new Watch(getGun(), getPlayer(), isHeald()).sendStopNotify(player);
                    break;
                default:
                    System.out.println("Unknown spy child");
            }
        } catch (Exception ignored) {}
    }

    @Override
    public void runAbility() {
        try {
            switch (getChildAbilities().get(0)) {
                case "watch":
                    new Watch(getGun(), getPlayer(), isHeald());
                    break;
                default:
                    System.out.println("Unknown spy child");
            }
        } catch (Exception ignored) {}
    }
}
