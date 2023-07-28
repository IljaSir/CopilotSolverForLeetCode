class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        
        def dfs(nums, path, used, res):
            if len(path) == len(nums):
                res.append(path)
                return
            for i in range(len(nums)):
                if used[i] or (i > 0 and nums[i] == nums[i - 1] and not used[i - 1]):
                    continue
                used[i] = True
                dfs(nums, path + [nums[i]], used, res)
                used[i] = False
        res = []
        nums.sort()
        dfs(nums, [], [False] * len(nums), res)
        return res