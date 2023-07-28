class Solution:
    def beautifulSubsets(self, nums: List[int], k: int) -> int:
        
        self.count = 0
        self.dfs(nums, k, 0, set())
        return self.count