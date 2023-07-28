class Solution:
    def longestObstacleCourseAtEachPosition(self, obstacles: List[int]) -> List[int]:
        
        # Dynamic Programming
        # O(NlogN)
        n = len(obstacles)
        dp = [obstacles[0]]
        res = [1]
        for i in range(1, n):
            if obstacles[i] >= dp[-1]:
                dp.append(obstacles[i])
                res.append(len(dp))
            else:
                idx = bisect.bisect_left(dp, obstacles[i])
                dp[idx] = obstacles[i]
                res.append(idx+1)
        return res