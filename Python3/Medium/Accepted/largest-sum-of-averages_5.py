class Solution:
    def largestSumOfAverages(self, nums: List[int], k: int) -> float:
        
        @lru_cache(maxsize=None)
        def dfs(i, k):
            if k == 1:
                return sum(nums[i:]) / len(nums[i:])
            res = 0
            for j in range(i, len(nums) - k + 1):
                res = max(res, sum(nums[i:j+1]) / (j - i + 1) + dfs(j+1, k-1))
            return res
        return dfs(0, k)