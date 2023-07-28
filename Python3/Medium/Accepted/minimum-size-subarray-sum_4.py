class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        if not nums:
            return 0
        l = 0
        r = 0
        s = 0
        res = float('inf')
        while r < len(nums):
            s += nums[r]
            r += 1
            while s >= target:
                res = min(res, r - l)
                s -= nums[l]
                l += 1
        return res if res != float('inf') else 0