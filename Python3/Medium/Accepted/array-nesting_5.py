class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        
        def dfs(i):
            if i in visited:
                return 0
            visited.add(i)
            return 1 + dfs(nums[i])
        visited = set()
        return max(dfs(i) for i in range(len(nums)))