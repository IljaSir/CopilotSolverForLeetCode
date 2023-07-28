class Solution:
    def maxScore(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        prefix = [0]
        for i in range(n):
            prefix.append(prefix[-1] + nums[i])
        res = 0
        for i in range(n):
            if nums[i] > 0:
                res = max(res, i + 1 + prefix[i])
        return res