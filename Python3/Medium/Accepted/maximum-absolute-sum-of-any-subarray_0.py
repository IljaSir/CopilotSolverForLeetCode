class Solution:
    def maxAbsoluteSum(self, nums: List[int]) -> int:
        
        sum = 0
        max_sum = 0
        min_sum = 0
        for num in nums:
            sum += num
            max_sum = max(max_sum, sum)
            min_sum = min(min_sum, sum)
        return max_sum - min_sum