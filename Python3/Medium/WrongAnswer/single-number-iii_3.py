class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        
        a = b = 0
        for n in nums:
            ab = a & b
            a = (a ^ n) & ~ab
            b = (b ^ n) & ~ab
        return [a, b]