class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        
        res = set()
        def dfs(nums, path):
            if len(nums) < 2:
                return
            for i in range(len(nums)):
                if nums[i] >= path[-1]:
                    res.add(tuple(path+[nums[i]]))
                    dfs(nums[i+1:], path+[nums[i]])
        for i in range(len(nums)):
            dfs(nums[i+1:], [nums[i]])
        return list(res)