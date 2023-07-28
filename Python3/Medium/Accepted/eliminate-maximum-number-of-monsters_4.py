class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        
        times = sorted(dist[i] / speed[i] for i in range(len(dist)))
        for i in range(len(times)):
            if i >= times[i]:
                return i
        return len(times)