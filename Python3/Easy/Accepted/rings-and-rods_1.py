class Solution:
    def countPoints(self, rings: str) -> int:
        
        rods = {}
        for i in range(0, len(rings), 2):
            if rings[i+1] not in rods:
                rods[rings[i+1]] = set()
            rods[rings[i+1]].add(rings[i])
        return sum([1 for rod in rods.values() if len(rod) == 3])