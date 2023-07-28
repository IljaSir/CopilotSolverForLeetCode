class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        
        n = len(dist)
        t = [0] * n
        for i in range(n):
            t[i] = math.ceil(dist[i] / speed[i])
        t.sort()
        for i in range(n):
            if t[i] <= i:
                return i
        return n