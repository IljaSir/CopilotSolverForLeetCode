class Solution:
    def sumSubseqWidths(self, nums: List[int]) -> int:
        
        MOD = 10**9 + 7
        nums.sort()
        n = len(nums)
        ans = 0
        for i in range(n):
            ans = (ans + (nums[i] - nums[n-1-i]) * pow(2, i, MOD) * pow(2, n-1-i, MOD)) % MOD
        return ans