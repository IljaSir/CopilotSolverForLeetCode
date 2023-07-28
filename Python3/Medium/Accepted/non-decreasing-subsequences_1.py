class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        
        ans = set()
        def dfs(nums, path):
            if len(path) >= 2:
                ans.add(tuple(path))
            for i in range(len(nums)):
                if not path or nums[i] >= path[-1]:
                    dfs(nums[i+1:], path + [nums[i]])
        dfs(nums, [])
        return ans