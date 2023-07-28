class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return 0
        res = []
        for i in range(len(nums)):
            res.append(sum([nums[(i+j)%len(nums)]*j for j in range(len(nums))]))
        return max(res)