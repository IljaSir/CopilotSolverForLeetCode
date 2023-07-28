class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        res = [[]]
        for i in range(len(nums)):
            res += [j + [nums[i]] for j in res]
        return res