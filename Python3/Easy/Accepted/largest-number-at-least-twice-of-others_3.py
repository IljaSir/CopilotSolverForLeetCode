class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return 0
        max_val = max(nums)
        max_idx = nums.index(max_val)
        for i in range(len(nums)):
            if i != max_idx:
                if max_val < 2 * nums[i]:
                    return -1
        return max_idx