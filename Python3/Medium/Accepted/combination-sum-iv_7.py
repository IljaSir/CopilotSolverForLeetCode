class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        
        @lru_cache(None)
        def dfs(target):
            if target == 0:
                return 1
            res = 0
            for num in nums:
                if target >= num:
                    res += dfs(target - num)
            return res
        return dfs(target)