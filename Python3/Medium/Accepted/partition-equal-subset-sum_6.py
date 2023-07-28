class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        
        total = sum(nums)
        if total % 2:
            return False
        target = total // 2
        n = len(nums)
        dp = [[False] * (target + 1) for _ in range(n)]
        dp[0][0] = True
        for i in range(1, n):
            dp[i][0] = True
        for j in range(1, target + 1):
            dp[0][j] = nums[0] == j
        for i in range(1, n):
            for j in range(1, target + 1):
                dp[i][j] = dp[i - 1][j]
                if nums[i] <= j:
                    dp[i][j] = dp[i][j] or dp[i - 1][j - nums[i]]
        return dp[n - 1][target]