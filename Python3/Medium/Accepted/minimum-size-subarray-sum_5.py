class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        i = 0
        j = 0
        n = len(nums)
        res = n + 1
        total = 0
        while j < n:
            total += nums[j]
            while total >= target:
                res = min(res, j - i + 1)
                total -= nums[i]
                i += 1
            j += 1
        if res == n + 1:
            return 0
        return res