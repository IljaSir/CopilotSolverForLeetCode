class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        def dfs(nums, index, path, res):
            if len(path) == k and sum(path) == n:
                res.append(path)
                return
            for i in range(index, len(nums)):
                dfs(nums, i + 1, path + [nums[i]], res)
        
        res = []
        dfs(list(range(1, 10)), 0, [], res)
        return res