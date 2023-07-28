class Solution:
    def evenOddBit(self, n: int) -> List[int]:
        
        n = bin(n)[2:][::-1]
        return [n.count('1', i, i+2) for i in range(0, len(n), 2)]