class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        
        res = []
        def dfs(i, path):
            if len(path) >= 2:
                res.append(path)
            seen = set()
            for j in range(i, len(nums)):
                if nums[j] in seen:
                    continue
                if not path or nums[j] >= path[-1]:
                    seen.add(nums[j])
                    dfs(j+1, path + [nums[j]])
        dfs(0, [])
        return res