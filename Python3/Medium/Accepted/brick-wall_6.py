class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        
        n = len(wall)
        d = {}
        for i in range(n):
            m = len(wall[i])
            s = 0
            for j in range(m-1):
                s += wall[i][j]
                d[s] = d.get(s, 0) + 1
        return n - max(d.values()) if d else n