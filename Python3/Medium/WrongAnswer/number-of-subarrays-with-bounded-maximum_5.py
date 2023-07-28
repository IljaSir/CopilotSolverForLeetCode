class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        
        n = len(nums)
        res = 0
        l = 0
        for r in range(n):
            if nums[r] > right:
                l = r + 1
            if nums[r] >= left:
                res += r - l + 1
        return res