class Solution:
    def sumSubseqWidths(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        res = 0
        mod = 10**9 + 7
        for i in range(n):
            res = (res + (nums[i] - nums[n-1-i]) * (2**i - 2**(n-1-i))) % mod
        return res