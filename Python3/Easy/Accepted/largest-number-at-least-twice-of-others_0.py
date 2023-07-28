class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return 0
        if len(nums) == 2:
            if nums[0] >= 2*nums[1]:
                return 0
            if nums[1] >= 2*nums[0]:
                return 1
            return -1
        max_index = 0
        for i in range(1, len(nums)):
            if nums[i] > nums[max_index]:
                max_index = i
        for i in range(len(nums)):
            if i != max_index and nums[max_index] < 2*nums[i]:
                return -1
        return max_index