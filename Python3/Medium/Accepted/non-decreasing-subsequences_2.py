class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        
        ans = set()
        def dfs(i, path):
            if len(path) > 1:
                ans.add(tuple(path))
            for j in range(i, len(nums)):
                if not path or nums[j] >= path[-1]:
                    dfs(j + 1, path + [nums[j]])
        dfs(0, [])
        return ans