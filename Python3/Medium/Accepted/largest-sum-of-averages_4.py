class Solution:
    def largestSumOfAverages(self, nums: List[int], k: int) -> float:
        
        @lru_cache(None)
        def dp(i, k):
            if k == 1:
                return sum(nums[i:]) / (len(nums) - i)
            if i == len(nums) - 1:
                return nums[i]
            return max(dp(j, k - 1) + sum(nums[i:j]) / (j - i) for j in range(i + 1, len(nums)))
        return dp(0, k)