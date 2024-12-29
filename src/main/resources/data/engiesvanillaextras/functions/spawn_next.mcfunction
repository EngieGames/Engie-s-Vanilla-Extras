summon item ~ ~ ~ {Tags: ["ps-keep"], Item: {id: "minecraft:stone", Count: 1b}}
execute store result entity @e[type=item, tag=ps-keep, limit=1] Age short 1 run scoreboard players get item_despawn_offset config.ps-keep
execute as @e[type=item, tag=ps-keep, limit=1] run data modify entity @s Item set from storage ps:keep spawn[-1]
tag @e[type=item, tag=ps-keep, limit=1] remove ps-keep
