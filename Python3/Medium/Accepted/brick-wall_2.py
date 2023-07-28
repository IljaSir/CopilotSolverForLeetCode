class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        
        d = {}
        for row in wall:
            s = 0
            for i in range(len(row)-1):
                s += row[i]
                d[s] = d.get(s, 0) + 1
        return len(wall) - max(d.values()) if d else len(wall)