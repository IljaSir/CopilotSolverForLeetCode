class Solution:
    def totalSteps(self, nums: List[int]) -> int:
        
        steps = 0
        for i in range(1, len(nums)):
            if nums[i-1] > nums[i]:
                steps += 1
                nums[i] = nums[i-1]
        return steps