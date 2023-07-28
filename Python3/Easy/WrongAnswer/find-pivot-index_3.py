class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return -1
        if len(nums) == 1:
            return 0
        if len(nums) == 2:
            return -1
        total_sum = sum(nums)
        left_sum = 0
        for i in range(len(nums)):
            if left_sum == total_sum - left_sum - nums[i]:
                return i
            left_sum += nums[i]
        return -1