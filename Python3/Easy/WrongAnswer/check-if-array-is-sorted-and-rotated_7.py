class Solution:
    def check(self, nums: List[int]) -> bool:
        
        if len(nums) == 1:
            return True
        if nums[0] > nums[-1]:
            return False
        for i in range(1, len(nums)):
            if nums[i] < nums[i-1]:
                return False
        return True