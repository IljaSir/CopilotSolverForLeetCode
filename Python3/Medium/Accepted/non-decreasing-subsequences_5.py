class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        
        def dfs(nums, i, path):
            if len(path) > 1:
                res.append(path)
            used = set()
            for j in range(i, len(nums)):
                if nums[j] in used:
                    continue
                if not path or nums[j] >= path[-1]:
                    used.add(nums[j])
                    dfs(nums, j + 1, path + [nums[j]])
        res = []
        dfs(nums, 0, [])
        return res