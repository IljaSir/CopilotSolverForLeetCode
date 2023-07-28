class Solution:
    def longestArithSeqLength(self, nums: List[int]) -> int:
        
        n = len(nums)
        dp = [{} for _ in range(n)]
        res = 0
        for i in range(1, n):
            for j in range(i):
                d = nums[i] - nums[j]
                dp[i][d] = dp[j].get(d, 1) + 1
                res = max(res, dp[i][d])
        return res