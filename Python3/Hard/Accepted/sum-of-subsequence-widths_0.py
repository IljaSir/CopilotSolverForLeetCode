class Solution:
    def sumSubseqWidths(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        res = 0
        for i in range(n):
            res = (res + nums[i] * pow(2, i, 10**9+7) - nums[i] * pow(2, n-1-i, 10**9+7)) % (10**9+7)
        return res