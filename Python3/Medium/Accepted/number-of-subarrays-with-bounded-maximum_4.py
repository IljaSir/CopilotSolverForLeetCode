class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        
        res, l, r = 0, -1, -1
        for i, n in enumerate(nums):
            if n > right:
                l, r = i, i
            elif n >= left:
                r = i
            res += r - l
        return res