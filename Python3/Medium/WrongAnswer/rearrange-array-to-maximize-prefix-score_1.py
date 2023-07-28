class Solution:
    def maxScore(self, nums: List[int]) -> int:
        
        nums.sort()
        prefix = [0]
        for num in nums:
            prefix.append(prefix[-1] + num)
        res = 0
        for i in range(len(prefix)):
            if prefix[i] > 0:
                res = max(res, len(prefix) - i - 1)
        return res