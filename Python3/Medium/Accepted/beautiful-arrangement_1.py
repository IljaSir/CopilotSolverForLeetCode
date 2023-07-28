class Solution:
    def countArrangement(self, n: int) -> int:
        
        def dfs(index, nums):
            if index == 1:
                return 1
            count = 0
            for i in range(len(nums)):
                if nums[i] % index == 0 or index % nums[i] == 0:
                    count += dfs(index - 1, nums[:i] + nums[i + 1:])
            return count
        return dfs(n, list(range(1, n + 1)))