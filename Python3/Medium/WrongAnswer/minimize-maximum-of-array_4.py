class Solution:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        
        # 1. Sort
        # 2. Get the minimum difference of each item
        # 3. Add the minimum difference to the first item
        nums.sort()
        min_diff = nums[1] - nums[0]
        for i in range(2, len(nums)):
            diff = nums[i] - nums[i - 1]
            if diff < min_diff:
                min_diff = diff
        return nums[0] + min_diff