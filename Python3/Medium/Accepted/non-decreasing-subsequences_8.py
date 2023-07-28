class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        
        def dfs(nums, i, path, res):
            if len(path) >= 2:
                res.append(path)
            seen = set()
            for j in range(i, len(nums)):
                if (nums[j] in seen): continue
                if (not path or nums[j] >= path[-1]):
                    seen.add(nums[j])
                    dfs(nums, j + 1, path + [nums[j]], res)
        res = []
        dfs(nums, 0, [], res)
        return res