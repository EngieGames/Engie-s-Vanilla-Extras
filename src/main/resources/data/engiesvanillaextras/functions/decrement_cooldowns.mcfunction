schedule function minecraft:decrement_cooldowns 1s
execute as @a[scores={tpa.cooldown=1..}] run function minecraft:decrement_cooldown