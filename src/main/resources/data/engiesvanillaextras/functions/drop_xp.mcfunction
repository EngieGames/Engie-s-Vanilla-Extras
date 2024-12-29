execute store result score .level ps-keep run xp query @s levels
scoreboard players operation .xp ps-keep = .level ps-keep
scoreboard players operation .xp ps-keep *= .level ps-keep
scoreboard players operation #temp ps-keep = .level ps-keep
execute if score .level ps-keep matches 17..31 run scoreboard players operation .xp ps-keep *= .5 ps-keep
execute if score .level ps-keep matches 32.. run scoreboard players operation .xp ps-keep *= .9 ps-keep
execute if score .level ps-keep matches 1..16 run scoreboard players operation #temp ps-keep *= .6 ps-keep
execute if score .level ps-keep matches 17..31 run scoreboard players operation #temp ps-keep *= .-81 ps-keep
execute if score .level ps-keep matches 32.. run scoreboard players operation #temp ps-keep *= .-325 ps-keep
scoreboard players operation .xp ps-keep += #temp ps-keep
execute if score .level ps-keep matches 17.. run scoreboard players operation .xp ps-keep /= .2 ps-keep
execute if score .level ps-keep matches 17..31 run scoreboard players add .xp ps-keep 360
execute if score .level ps-keep matches 32.. run scoreboard players add .xp ps-keep 2220
execute store result score #temp ps-keep run xp query @s points
scoreboard players operation .xp ps-keep += #temp ps-keep
summon experience_orb ~ ~ ~ {Tags: ["ps-keep"]}
execute store result entity @e[type=experience_orb, tag=ps-keep, limit=1] Value short 1 run scoreboard players get .xp ps-keep
tag @e[type=experience_orb, tag=ps-keep, limit=1] remove ps-keep
xp set @s 0 levels
xp set @s 0 points
