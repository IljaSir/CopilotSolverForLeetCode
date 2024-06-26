class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        
        n = len(nums)
        s = sum(nums)
        t = sum(i * v for i, v in enumerate(nums))
        res = t
        for i in range(n - 1, 0, -1):
            t = t + s - n * nums[i]
            res = max(res, t)
        return res