class Solution:
    def evenOddBit(self, n: int) -> List[int]:
        
        even = bin(n)[2::2].count('1')
        odd = bin(n)[3::2].count('1')
        return [even, odd]