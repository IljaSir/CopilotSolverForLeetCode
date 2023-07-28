class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        i, j = 0, 0
        s = 0
        n = len(nums)
        res = n + 1
        while j < n:
            s += nums[j]
            while s >= target:
                res = min(res, j - i + 1)
                s -= nums[i]
                i += 1
            j += 1
        return 0 if res == n + 1 else res