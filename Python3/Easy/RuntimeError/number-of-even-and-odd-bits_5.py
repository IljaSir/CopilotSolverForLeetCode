class Solution:
    def evenOddBit(self, n: int) -> List[int]:
        
        return [bin(n).count('1') - bin(n).count('1', 1, None, 2), bin(n).count('1', 1, None, 2)]