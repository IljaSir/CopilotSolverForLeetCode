class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return 0
        res = [0]*len(nums)
        for i in range(len(nums)):
            for j in range(len(nums)):
                res[i] += j*nums[(i+j)%len(nums)]
        return max(res)