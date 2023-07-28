class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return nums[0]
        max_sum = 0
        current_sum = 0
        for i in range(len(nums)):
            if i == 0:
                current_sum += nums[i]
            elif nums[i] > nums[i-1]:
                current_sum += nums[i]
            else:
                if current_sum > max_sum:
                    max_sum = current_sum
                current_sum = nums[i]
        if current_sum > max_sum:
            max_sum = current_sum
        return max_sum