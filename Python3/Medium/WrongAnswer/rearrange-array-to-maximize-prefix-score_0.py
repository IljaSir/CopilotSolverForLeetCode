class Solution:
    def maxScore(self, nums: List[int]) -> int:
        
        nums.sort()
        prefix = [nums[0]]
        for i in range(1, len(nums)):
            prefix.append(prefix[-1] + nums[i])
        score = 0
        for i in range(len(nums)):
            if prefix[i] > 0:
                score += 1
        return score