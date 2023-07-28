class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        maxp = minp = res = nums[0]
        for n in nums[1:]:
            maxp, minp = max(n, maxp*n, minp*n), min(n, maxp*n, minp*n)
            res = max(res, maxp)
        return res