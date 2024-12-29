scoreboard players reset @s ps-keep
execute if score keep_items ps-keep.config matches 0..1 run clear @s ps-keep:all{Enchantments: [{id: "vanishing_curse"}]}
execute if score keep_items ps-keep.config matches 0..1 run data modify storage ps:keep spawn set from entity @s Inventory
execute if score keep_items ps-keep.config matches 0 run clear @s
execute if score keep_items ps-keep.config matches 1 run clear @s ps-keep:drop_on_death
execute if score keep_items ps-keep.config matches 1 run data modify storage ps:keep inv set from storage ps:keep spawn
execute if score keep_items ps-keep.config matches 1 run data modify storage ps:keep kept set from entity @s Inventory
execute if score keep_items ps-keep.config matches 0 if data storage ps:keep spawn[0] run function engiesvanillaextras:spawn_all
execute if score keep_items ps-keep.config matches 1 run function engiesvanillaextras:loop_through_inv
execute if score keep_experience ps-keep.config matches 0 run function engiesvanillaextras:drop_xp
