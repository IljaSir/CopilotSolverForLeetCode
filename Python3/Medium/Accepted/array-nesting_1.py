class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        
        def dfs(i):
            if visited[i]:
                return 0
            visited[i] = True
            return 1 + dfs(nums[i])
        visited = [False] * len(nums)
        return max(dfs(i) for i in range(len(nums)))