class Solution:
    def sumSubseqWidths(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        total = 0
        for i in range(n):
            total += nums[i] * pow(2, i, 10**9+7) - nums[i] * pow(2, n-1-i, 10**9+7)
        return total % (10**9+7)