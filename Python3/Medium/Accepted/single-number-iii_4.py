class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        
        a = 0
        for n in nums:
            a ^= n
        b = 1
        while a & b == 0:
            b <<= 1
        c = 0
        d = 0
        for n in nums:
            if n & b == 0:
                c ^= n
            else:
                d ^= n
        return [c, d]