
package net.mcreator.engiesvanillaextras.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

import net.mcreator.engiesvanillaextras.procedures.GMProcedureProcedure;

import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class GmCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("gm").requires(s -> s.hasPermission(3)).then(Commands.argument("mode", DoubleArgumentType.doubleArg()).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			GMProcedureProcedure.execute(arguments, entity);
			return 0;
		})));
	}
}
