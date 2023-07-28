class Solution:
    def maximizeGreatness(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        res = 0
        for i in range(n):
            res += nums[i] - nums[n - 1 - i]
        return res