class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        
        n = len(nums)
        @lru_cache(None)
        def dfs(i, s1, s2):
            if i >= n:
                return abs(s1 - s2)
            return min(dfs(i + 1, s1 + nums[i], s2), dfs(i + 1, s1, s2 + nums[i]))
        return dfs(0, 0, 0)