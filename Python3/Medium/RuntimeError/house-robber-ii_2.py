class Solution:
    def rob(self, nums: List[int]) -> int:
        
        def rob_range(nums, start, end):
            first, second = nums[start], max(nums[start], nums[start + 1])
            for i in range(start + 2, end + 1):
                first, second = second, max(first + nums[i], second)
            return second
        
        n = len(nums)
        if n == 1:
            return nums[0]
        return max(rob_range(nums, 0, n - 2), rob_range(nums, 1, n - 1))