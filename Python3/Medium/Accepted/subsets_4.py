class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        n = len(nums)
        res = []
        for i in range(2**n):
            res.append([])
            for j in range(n):
                if i & (1 << j):
                    res[-1].append(nums[j])
        return res