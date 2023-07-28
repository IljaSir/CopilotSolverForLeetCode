class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        
        return sum(c == '1' for c in bin(x ^ y))