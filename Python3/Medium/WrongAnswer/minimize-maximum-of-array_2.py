class Solution:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        
        return sum(nums) - len(nums) * min(nums)