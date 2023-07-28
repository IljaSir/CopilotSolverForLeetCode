class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        
        n = len(dist)
        time = [0] * n
        for i in range(n):
            time[i] = dist[i] / speed[i]
        time.sort()
        for i in range(n):
            if i >= time[i]:
                return i
        return n