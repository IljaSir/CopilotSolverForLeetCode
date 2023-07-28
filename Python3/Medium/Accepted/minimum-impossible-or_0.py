class Solution:
    def minImpossibleOR(self, nums: List[int]) -> int:
        
        nums.sort()
        if nums[0] != 1:
            return 1
        res = 1
        for i in range(1, len(nums)):
            if nums[i] > res + 1:
                return res + 1
            res |= nums[i]
        return res + 1