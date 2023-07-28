class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        
        
        def canFinish(speed):
            time = 0
            for i in range(len(dist)-1):
                time += math.ceil(dist[i]/speed)
            time += dist[-1]/speed
            return time <= hour
        
        left, right = 1, 10**7
        while left <= right:
            mid = (left + right) // 2
            if canFinish(mid):
                right = mid - 1
            else:
                left = mid + 1
        return left if left <= 10**7 else -1