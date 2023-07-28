class Solution:
    def minSubsequence(self, nums: List[int]) -> List[int]:
        
        nums.sort(reverse=True)
        total = sum(nums)
        res = []
        for i in range(len(nums)):
            res.append(nums[i])
            if sum(res) > total - sum(res):
                return res