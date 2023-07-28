class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        
        min = nums[0]
        max = nums[0]
        min_index = 0
        max_index = 0
        for i in range(0,len(nums)):
            if nums[i] < min:
                min = nums[i]
                min_index = i
            if nums[i] > max:
                max = nums[i]
                max_index = i
        if min_index < max_index:
            return len(nums) - min_index - 1 + max_index - 1
        else:
            return len(nums) - min_index - 1 + max_index