class Solution:
    def countPoints(self, rings: str) -> int:
        
        from collections import defaultdict
        d = defaultdict(set)
        for i in range(0,len(rings),2):
            d[rings[i+1]].add(rings[i])
        return sum(1 for x in d.values() if len(x)==3)