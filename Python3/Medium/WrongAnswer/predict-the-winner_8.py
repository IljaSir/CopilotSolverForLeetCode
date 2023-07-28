class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        
        def dfs(i, j, player1):
            if i == j:
                return nums[i] * player1
            return max(nums[i] * player1 + dfs(i + 1, j, -player1), nums[j] * player1 + dfs(i, j - 1, -player1)) * player1
        return dfs(0, len(nums) - 1, 1) >= 0