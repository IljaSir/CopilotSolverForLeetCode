class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        dp = [defaultdict(int) for _ in range(len(nums))]
        res = 0
        for i in range(len(nums)):
            for j in range(i):
                d = nums[i] - nums[j]
                dp[i][d] += 1
                if d in dp[j]:
                    dp[i][d] += dp[j][d]
                    res += dp[j][d]
        return res