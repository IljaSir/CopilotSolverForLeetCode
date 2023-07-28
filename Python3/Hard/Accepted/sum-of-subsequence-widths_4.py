class Solution:
    def sumSubseqWidths(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        res = 0
        mod = 10**9 + 7
        for i in range(n):
            res += (nums[i] - nums[n - i - 1]) * pow(2, i, mod)
            res %= mod
        return res