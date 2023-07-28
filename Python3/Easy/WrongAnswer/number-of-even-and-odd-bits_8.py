class Solution:
    def evenOddBit(self, n: int) -> List[int]:
        
        b = bin(n)[2:]
        return [b.count('1', i) for i in (0, 1)]