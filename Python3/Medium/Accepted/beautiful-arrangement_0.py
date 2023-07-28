class Solution:
    def countArrangement(self, n: int) -> int:
        
        def dfs(nums, pos):
            if pos == 1:
                return 1
            res = 0
            for i in range(len(nums)):
                if nums[i] % pos == 0 or pos % nums[i] == 0:
                    res += dfs(nums[:i] + nums[i+1:], pos-1)
            return res
        return dfs(list(range(1, n+1)), n)