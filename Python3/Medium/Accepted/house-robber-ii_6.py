class Solution:
    def rob(self, nums: List[int]) -> int:
        
        def rob_range(start: int, end: int) -> int:
            first = second = 0
            for i in range(start, end):
                first, second = second, max(first + nums[i], second)
            return second

        n = len(nums)
        if n == 1:
            return nums[0]
        return max(rob_range(0, n - 1), rob_range(1, n))