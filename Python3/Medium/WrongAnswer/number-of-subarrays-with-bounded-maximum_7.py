class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        
        # 1. sliding window
        # 2. dp
        dp = [0]*len(nums)
        for i in range(len(nums)):
            if nums[i] >= left and nums[i] <= right:
                dp[i] = 1
            elif nums[i] < left:
                if i > 0:
                    dp[i] = dp[i-1]
        # print(dp)
        res = 0
        for i in range(len(nums)):
            if dp[i] == 1:
                j = i
                while j < len(nums) and nums[j] <= right:
                    res += 1
                    j += 1
        return res