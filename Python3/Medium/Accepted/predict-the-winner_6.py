class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        
        dp = {}
        def helper(i, j):
            if (i, j) in dp:
                return dp[(i, j)]
            if i == j:
                dp[(i, j)] = nums[i]
                return dp[(i, j)]
            if i > j:
                dp[(i, j)] = 0
                return dp[(i, j)]
            dp[(i, j)] = max(nums[i] - helper(i + 1, j), nums[j] - helper(i, j - 1))
            return dp[(i, j)]
        
        return helper(0, len(nums) - 1) >= 0