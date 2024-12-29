execute store success score .bool2 ps-keep run data modify storage ps:keep inv[-1] set from storage ps:keep kept[-1]
execute if score .bool2 ps-keep matches 0 unless data storage ps:keep kept[0] run scoreboard players set .bool2 ps-keep 1
execute if score .bool2 ps-keep matches 0 run data remove storage ps:keep kept[-1]
execute if score .bool2 ps-keep matches 1 run function engiesvanilaextras:spawn_next
data remove storage ps:keep inv[-1]
data remove storage ps:keep spawn[-1]
execute store success score .bool1 ps-keep if data storage ps:keep kept[0]
execute if score .bool1 ps-keep matches 0 if data storage ps:keep spawn[0] run function engiesvanillaextras:spawn_all
execute if score .bool1 ps-keep matches 1 run function engiesvanillaextras:loop_through_inv