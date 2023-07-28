class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        
        ans = []
        def dfs(nums, path):
            if len(path) >= 2:
                ans.append(path)
            if not nums:
                return
            for i in range(len(nums)):
                if i > 0 and nums[i] == nums[i-1]:
                    continue
                if not path or nums[i] >= path[-1]:
                    dfs(nums[i+1:], path + [nums[i]])
        dfs(nums, [])
        return ans