class Solution:
    def largestSumOfAverages(self, nums: List[int], k: int) -> float:
        
        def average(nums):
            return sum(nums) / len(nums)
        def helper(nums, k):
            if k == 1:
                return average(nums)
            res = 0
            for i in range(len(nums)):
                res = max(res, average(nums[:i+1]) + helper(nums[i+1:], k-1))
            return res
        return helper(nums, k)