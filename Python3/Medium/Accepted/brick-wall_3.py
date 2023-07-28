class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        
        d = collections.defaultdict(int)
        for row in wall:
            s = 0
            for x in row[:-1]:
                s += x
                d[s] += 1
        return len(wall) - max(d.values() or [0])