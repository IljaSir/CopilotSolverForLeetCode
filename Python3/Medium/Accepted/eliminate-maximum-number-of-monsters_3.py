class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        
        time = [dist[i] / speed[i] for i in range(len(dist))]
        time.sort()
        count = 0
        for i in range(len(time)):
            if time[i] > i:
                count += 1
            else:
                break
        return count