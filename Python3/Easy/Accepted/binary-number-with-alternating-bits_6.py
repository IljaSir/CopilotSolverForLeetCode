class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        
        # print(bin(n))
        # print(bin(n >> 1))
        return (n + (n >> 1) + 1) & (n + (n >> 1)) == 0