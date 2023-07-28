class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        
        n = len(nums)
        s = sum(nums)
        res = 0
        for i in range(n):
            res += i*nums[i]
        max_res = res
        for i in range(1, n):
            res = res + s - n*nums[n-i]
            max_res = max(max_res, res)
        return max_res