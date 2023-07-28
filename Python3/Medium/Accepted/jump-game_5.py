class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        if len(nums) == 1:
            return True
        if nums[0] == 0:
            return False
        i = 0
        while i < len(nums):
            if i + nums[i] >= len(nums) - 1:
                return True
            if nums[i] == 0:
                return False
            max_step = 0
            max_index = 0
            for j in range(1, nums[i] + 1):
                if nums[i + j] + j > max_step:
                    max_step = nums[i + j] + j
                    max_index = j
            i += max_index