class Solution:
    def rob(self, nums: List[int]) -> int:
        
        def robRange(start: int, end: int) -> int:
            first = second = 0
            for i in range(start, end):
                first, second = second, max(first + nums[i], second)
            return second
        n = len(nums)
        if n == 1:
            return nums[0]
        return max(robRange(0, n - 1), robRange(1, n))