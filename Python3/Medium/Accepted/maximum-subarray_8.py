class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        
        # Kadane's algorithm
        if len(nums) == 1:
            return nums[0]
        for i in range(1, len(nums)):
            if nums[i-1] > 0:
                nums[i] += nums[i-1]
        return max(nums)