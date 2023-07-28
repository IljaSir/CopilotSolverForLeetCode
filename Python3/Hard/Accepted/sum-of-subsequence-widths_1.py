class Solution:
    def sumSubseqWidths(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        res = 0
        for i in range(n):
            res += (pow(2, i, 10**9+7) - pow(2, n-i-1, 10**9+7)) * nums[i]
        return res % (10**9+7)