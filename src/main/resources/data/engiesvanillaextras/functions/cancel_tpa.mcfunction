tag @s add tpa.cancelSender
scoreboard players reset @s tpa.target
scoreboard players reset @s tpa.timeout
tag @a[tag=tpa.cancelSender] remove tpa.cancelSender
tag @a[tag=tpa.sender] remove tpa.sender
tag @a[tag=tpa.target] remove tpa.target