class Solution:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        
        return max(nums) - min(nums)