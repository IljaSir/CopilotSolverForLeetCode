class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        if len(nums) < 3: return 0
        dp = [{} for _ in range(len(nums))]
        ans = 0
        for i in range(len(nums)):
            for j in range(i):
                diff = nums[i] - nums[j]
                cnt = dp[j].get(diff, 0)
                ans += cnt
                dp[i][diff] = dp[i].get(diff, 0) + cnt + 1
        return ans