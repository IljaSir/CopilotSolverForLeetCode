class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        
        memo = {}
        def dp(n):
            if n == 0:
                return 1
            if n < 0:
                return 0
            if n in memo:
                return memo[n]
            res = 0
            for num in nums:
                res += dp(n - num)
            memo[n] = res
            return res
        return dp(target)