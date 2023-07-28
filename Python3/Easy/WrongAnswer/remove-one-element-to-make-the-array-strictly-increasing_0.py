class Solution:
    def canBeIncreasing(self, nums: List[int]) -> bool:
        
        if len(nums) == 2:
            return True
        if len(nums) == 3:
            return nums[0] < nums[1] < nums[2] or nums[0] < nums[2]
        for i in range(len(nums)):
            if i == 0:
                if nums[i] < nums[i+1] and nums[i] < nums[i+2]:
                    continue
            elif i == len(nums) - 1:
                if nums[i] > nums[i-1] and nums[i] > nums[i-2]:
                    continue
            else:
                if nums[i] > nums[i-1] and nums[i] < nums[i+1]:
                    continue
            if self.canBeIncreasing(nums[:i] + nums[i+1:]):
                return True
        return False