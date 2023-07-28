class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        
        return [int(x) for x in ''.join([str(x) for x in nums])]