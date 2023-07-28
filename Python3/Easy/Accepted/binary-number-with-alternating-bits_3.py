class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        
        bin_str = bin(n)[2:]
        return all(bin_str[i] != bin_str[i + 1] for i in range(len(bin_str) - 1))