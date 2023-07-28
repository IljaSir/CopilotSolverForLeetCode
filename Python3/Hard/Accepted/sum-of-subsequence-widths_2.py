class Solution:
    def sumSubseqWidths(self, nums: List[int]) -> int:
        
        nums.sort()
        result = 0
        for i in range(len(nums)):
            result += nums[i] * pow(2, i, 10**9+7)
            result -= nums[i] * pow(2, len(nums)-i-1, 10**9+7)
        return result % (10**9+7)