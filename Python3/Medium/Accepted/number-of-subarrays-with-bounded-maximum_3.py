class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        
        l, r = -1, -1
        res = 0
        for i, n in enumerate(nums):
            if n > right:
                l = i
            if n >= left:
                r = i
            res += r - l
        return res