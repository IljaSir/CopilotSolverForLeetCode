class Solution:
    def maximizeGreatness(self, nums: List[int]) -> int:
        
        nums.sort()
        res = 0
        for i in range(len(nums)):
            res += nums[i] - i
        return res