class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        
        m = {}
        for row in wall:
            s = 0
            for i in range(len(row)-1):
                s += row[i]
                if s not in m:
                    m[s] = 0
                m[s] += 1
        if len(m) == 0:
            return len(wall)
        return len(wall) - max(m.values())