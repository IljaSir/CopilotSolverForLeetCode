class Solution:
    def maximizeGreatness(self, nums: List[int]) -> int:
        
        nums = sorted(nums)
        res = 0
        for i in range(len(nums)):
            res += nums[i] > nums[res]
        return res