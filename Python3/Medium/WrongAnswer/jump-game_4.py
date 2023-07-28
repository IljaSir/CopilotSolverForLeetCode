class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        if len(nums) == 1:
            return True
        i = 0
        while i < len(nums) - 1:
            if nums[i] == 0:
                return False
            i += nums[i]
        return True