class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        res = []
        self.dfs(nums, 0, [], res)
        return res