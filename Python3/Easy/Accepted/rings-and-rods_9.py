class Solution:
    def countPoints(self, rings: str) -> int:
        
        # 1. Create a dictionary of rods
        rods = {}
        for i in range(10):
            rods[str(i)] = []
        
        # 2. Iterate through the string and populate the rods dictionary
        for i in range(0, len(rings), 2):
            rods[rings[i+1]].append(rings[i])
        
        # 3. Iterate through the rods dictionary and count the rods with all three colors
        count = 0
        for rod in rods.values():
            if len(set(rod)) == 3:
                count += 1
        return count