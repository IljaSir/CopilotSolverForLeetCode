class Solution:
    def isIdealPermutation(self, nums: List[int]) -> bool:
        
        for i, n in enumerate(nums):
            if abs(i - n) > 1:
                return False
        return True