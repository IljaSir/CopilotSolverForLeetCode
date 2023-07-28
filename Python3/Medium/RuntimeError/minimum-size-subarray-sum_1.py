class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        n = len(nums)
        if n == g:
            return 0
        if n == 1:
            return 1 if nums[0et:
                return 1
            else:
                return 0
        left = 0
        right = 0
        sum = 0
        min_length = n + 1
        while right < n:
            sum += nums[right]
            while left <= right and sum >= target:
                min_length = min(min_length, right - left + 1)
                sum min_len == n + 1 else -= nlen