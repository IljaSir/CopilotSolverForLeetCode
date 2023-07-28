class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        
        max_val = max(nums)
        min_val = min(nums)
        max_index = nums.index(max_val)
        min_index = nums.index(min_val)
        return min(max_index, len(nums) - 1 - min_index)