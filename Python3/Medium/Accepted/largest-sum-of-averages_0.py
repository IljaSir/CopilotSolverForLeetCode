class Solution:
    def largestSumOfAverages(self, nums: List[int], k: int) -> float:
        
        @lru_cache(None)
        def dp(i, k):
            if k == 1:
                return sum(nums[i:]) / (len(nums) - i)
            return max(dp(j + 1, k - 1) + sum(nums[i:j + 1]) / (j - i + 1) for j in range(i, len(nums) - k + 1))
        return dp(0, k)