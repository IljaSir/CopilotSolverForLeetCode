class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        
        n = len(dist)
        if n == 1:
            return 1
        t = [dist[i] / speed[i] for i in range(n)]
        t.sort()
        for i in range(n):
            if t[i] <= i:
                return i
        return n