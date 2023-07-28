class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return 0
        max1 = max(nums)
        max1_index = nums.index(max1)
        nums.remove(max1)
        max2 = max(nums)
        if max1 >= max2 * 2:
            return max1_index
        return -1