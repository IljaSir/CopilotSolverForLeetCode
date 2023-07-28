class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        
        n = len(nums)
        res = []
        def dfs(path, nums, n):
            if len(path) == n:
                res.append(path[:])
            for i in range(len(nums)):
                if i > 0 and nums[i] == nums[i-1]:
                    continue
                path.append(nums[i])
                dfs(path, nums[:i]+nums[i+1:], n)
                path.pop()
        dfs([], sorted(nums), n)
        return res