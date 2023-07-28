class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        if not nums:
            return 0
        l = 0
        r = 1
        s = nums[l]
        while r < len(nums) and s < target:
            s += nums[r]
            r += 1
        if s < target:
            return 0
        while l < r and s >= target:
            s -= nums[l]
            l += 1
        return r - l + 1