class Solution:
    def totalSteps(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        steps = 0
        for i in range(1, len(nums)):
            if nums[i] < nums[i - 1]:
                steps += nums[i - 1] - nums[i]
                nums[i] = nums[i - 1]
        return steps