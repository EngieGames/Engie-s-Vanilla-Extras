function engiesvanillaextras:spawn_next
data remove storage ps:keep spawn[-1]
execute if data storage ps:keep spawn[0] run function engiesvanillaextras:spawn_all
