class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        def dfs(i, cur):
            if i == n:
                if cur == target:
                    return 1
                else:
                    return 0
            return dfs(i+1, cur+nums[i]) + dfs(i+1, cur-nums[i])
        n = len(nums)
        return dfs(0, 0)