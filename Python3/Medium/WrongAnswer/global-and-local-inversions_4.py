class Solution:
    def isIdealPermutation(self, nums: List[int]) -> bool:
        
        n = len(nums)
        if n == 1: return True
        if n == 2: return nums[0] == 0 and nums[1] == 1
        for i in range(1, n):
            if abs(nums[i] - nums[i-1]) > 1:
                return False
        return True