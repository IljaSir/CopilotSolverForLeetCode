class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        
        min_val = min(nums)
        max_val = max(nums)
        min_val_idx = nums.index(min_val)
        max_val_idx = nums.index(max_val)
        if min_val_idx < max_val_idx:
            return min_val_idx + len(nums) - max_val_idx - 1
        else:
            return min_val_idx + len(nums) - max_val_idx - 2