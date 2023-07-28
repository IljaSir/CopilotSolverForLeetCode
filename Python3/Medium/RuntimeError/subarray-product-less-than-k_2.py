class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        
        if k == 0:
            return 0
        l = 0
        r = 0
        p = 1
        res = 0
        while r < len(nums):
            p *= nums[r]
            while p >= k:
                p /= nums[l]
                l += 1
            res += r - l + 1
            r += 1
        return res