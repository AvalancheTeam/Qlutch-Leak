/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.entity.Player;

public class ReplyCommand
extends Command {
    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        if (args.length < 2) {
            p2.sendMessage(Settings.USAGE("reply <message>"));
        } else {
            StringBuilder message = new StringBuilder();
            for (int i2 = 1; i2 != args.length; ++i2) {
                message.append(args[i2]).append(" ");
            }
            if (plugin.lastMsg.get(p2) == null) {
                p2.sendMessage(Settings.USAGE("You have no one to reply too!"));
            } else {
                Player target = plugin.lastMsg.get(p2);
                p2.sendMessage("§8[" + Settings.WHITE + "You to " + Settings.DARK_RED + target.getName() + "§8] §7" + message);
                target.sendMessage("§8[" + Settings.DARK_RED + p2.getName() + Settings.WHITE + " to you§8] §7" + message);
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}

