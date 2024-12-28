execute as @a[tag=tpa.sender] if score @s tpa.target matches 1.. run function engiesvanillaextras:cancel_tpa
scoreboard players operation @a[tag=tpa.sender] tpa.target = @a[tag=tpa.sender] tpa