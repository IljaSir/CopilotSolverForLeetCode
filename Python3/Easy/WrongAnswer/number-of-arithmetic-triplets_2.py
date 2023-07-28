class Solution:
    def arithmeticTriplets(self, nums: List[int], diff: int) -> int:
        
        dp = [0] * len(nums)
        for i in range(len(nums)):
            for j in range(i):
                if nums[i] - nums[j] == diff:
                    dp[i] += dp[j] + 1
        return sum(dp)