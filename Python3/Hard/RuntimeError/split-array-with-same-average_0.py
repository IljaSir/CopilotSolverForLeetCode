class Solution:
    def splitArraySameAverage(self, nums: List[int]) -> bool:
        
        s = sum(nums)
        n = len(nums)
        for i in range(1, n // 2 + 1):
            if s * i % n == 0 and self.dfs(nums, s * i // n, i):
                return True
        return False