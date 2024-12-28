package net.mcreator.engiesvanillaextras.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandFunction;

import net.mcreator.engiesvanillaextras.EngiesvanillaextrasMod;

import java.util.Optional;
import java.util.HashMap;

public class CallSendTPAProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return;
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.getLevel().getScoreboard();
			Objective _so = _sc.getObjective("tpa");
			if (_so == null)
				_so = _sc.addObjective("tpa", ObjectiveCriteria.DUMMY, Component.literal("tpa"), ObjectiveCriteria.RenderType.INTEGER);
			_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : ""));
		}
		EngiesvanillaextrasMod.queueServerWork(1, () -> {
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					Optional<CommandFunction> _fopt = _ent.getServer().getFunctions().get(new ResourceLocation("engiesvanillaextras:send_tpa"));
					if (_fopt.isPresent())
						_ent.getServer().getFunctions().execute(_fopt.get(), _ent.createCommandSourceStack());
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level.getServer(), _ent),
							"tellraw @a[tag=tpa.sender] [\"\",{\"text\":\"You have requested to teleport to \",\"color\":\"gold\"},{\"selector\":\"@a[tag=tpa.target,limit=1]\",\"color\":\"yellow\"},{\"text\":\". To cancel the request, type /tpcancel or click the underlined here: \",\"color\":\"gold\"},{\"text\":\"/tpcancel\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tpcancel\"}}]");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level.getServer(), _ent),
							"tellraw @a[tag=tpa.target] [\"\",{\"selector\":\"@a[tag=tpa.sender]\",\"color\":\"yellow\"},{\"text\":\" has sent you a teleport request, to accept type /tpaccept \\u0020or click the underlined here: \",\"color\":\"gold\"},{\"text\":\"/tpaccept 1\",\"underlined\":true,\"color\":\"gold\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tpaccept 1\"}}]");
				}
			}
		});
	}
}
