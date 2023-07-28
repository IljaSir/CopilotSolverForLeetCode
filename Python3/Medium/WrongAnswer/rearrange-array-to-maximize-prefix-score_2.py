class Solution:
    def maxScore(self, nums: List[int]) -> int:
        
        nums.sort()
        score = 0
        for i in range(len(nums)):
            if nums[i] > 0:
                score += 1
            if i > 0:
                nums[i] += nums[i - 1]
        return score