class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        n = len(nums)
        dp = [defaultdict(int) for _ in range(n)]
        dp[0][nums[0]] += 1
        dp[0][-nums[0]] += 1
        for i in range(1, n):
            for k, v in dp[i-1].items():
                dp[i][k+nums[i]] += v
                dp[i][k-nums[i]] += v
        return dp[n-1][target]