class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        
        max_sum = 0
        current_sum = 0
        for i in range(len(nums)):
            if i == 0:
                current_sum += nums[i]
            elif nums[i] > nums[i-1]:
                current_sum += nums[i]
            else:
                max_sum = max(current_sum, max_sum)
                current_sum = nums[i]
        return max(current_sum, max_sum)