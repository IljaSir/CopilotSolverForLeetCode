class Solution:
    def countPoints(self, rings: str) -> int:
        
        rods = collections.defaultdict(set)
        for i in range(0, len(rings), 2):
            rods[rings[i+1]].add(rings[i])
        return sum(len(v) == 3 for v in rods.values())