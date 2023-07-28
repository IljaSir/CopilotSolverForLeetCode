class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        nums.sort()
        i = 0
        while i < len(nums):
            j = i + 1
            while j < len(nums) and nums[j] == nums[i]:
                j += 1
            nums[i] = (nums[i], j - i)
            i = j
        dp = [0] * (len(nums) + 1)
        dp[1] = nums[0][0] * nums[0][1]
        for i in range(2, len(nums) + 1):
            if nums[i - 1][0] - 1 == nums[i - 2][0]:
                dp[i] = max(dp[i - 1], dp[i - 2] + nums[i - 1][0] * nums[i - 1][1])
            else:
                dp[i] = dp[i - 1] + nums[i - 1][0] * nums[i - 1][1]
        return dp[-1]