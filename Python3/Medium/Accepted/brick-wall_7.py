class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        
        from collections import defaultdict
        n = len(wall)
        d = defaultdict(int)
        for row in wall:
            s = 0
            for c in row[:-1]:
                s += c
                d[s] += 1
        if not d:
            return n
        return n - max(d.values())