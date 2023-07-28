class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        n = len(nums)
        dp = [defaultdict(int) for _ in range(n)]
        res = 0
        for i in range(n):
            for j in range(i):
                dp[i][nums[i] - nums[j]] += dp[j][nums[i] - nums[j]] + 1
                res += dp[j][nums[i] - nums[j]]
        return res