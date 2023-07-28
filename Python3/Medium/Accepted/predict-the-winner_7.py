class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        
        def helper(nums, i, j, turn):
            if i == j:
                return nums[i] if turn else -nums[i]
            if turn:
                return max(nums[i] + helper(nums, i+1, j, False), nums[j] + helper(nums, i, j-1, False))
            else:
                return min(-nums[i] + helper(nums, i+1, j, True), -nums[j] + helper(nums, i, j-1, True))
        return helper(nums, 0, len(nums)-1, True) >= 0