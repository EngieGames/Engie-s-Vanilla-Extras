execute unless score cooldown tpa.config matches 0 run scoreboard players operation @s tpa.cooldown = cooldown tpa.config
execute at @s run function back:set_back
tp @a[tag=tpa.sender] @a[tag=tpa.target,limit=1]
scoreboard players reset @s tpa.target
scoreboard players reset @s tpa.timeout
tag @a[tag=tpa.sender] remove tpa.sender
tag @a[tag=tpa.targer] remove tpa.target