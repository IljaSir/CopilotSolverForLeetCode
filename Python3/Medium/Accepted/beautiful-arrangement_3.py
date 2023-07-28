class Solution:
    def countArrangement(self, n: int) -> int:
        
        def dfs(nums, i):
            if i == 1:
                return 1
            return sum(dfs(nums[:j] + nums[j+1:], i-1) for j, num in enumerate(nums) if num % i == 0 or i % num == 0)
        return dfs(tuple(range(1, n+1)), n)