class Solution:
    def smallestRangeI(self, nums: List[int], k: int) -> int:
        
        if len(nums) == 1:
            return 0
        nums.sort()
        if nums[0] + k >= nums[-1] - k:
            return 0
        return nums[-1] - nums[0] - 2 * k