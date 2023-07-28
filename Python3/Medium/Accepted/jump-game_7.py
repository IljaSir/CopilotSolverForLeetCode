class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        if not nums or len(nums) == 1:
            return True
        max_index = 0
        for i, num in enumerate(nums):
            if i > max_index:
                return False
            max_index = max(max_index, i + num)
            if max_index >= len(nums) - 1:
                return True
        return False