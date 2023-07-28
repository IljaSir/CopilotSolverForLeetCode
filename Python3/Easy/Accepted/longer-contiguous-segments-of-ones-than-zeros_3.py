class Solution:
    def checkZeroOnes(self, s: str) -> bool:
        
        max_ones = max_zeros = 0
        ones = zeros = 0
        for c in s:
            if c == '0':
                zeros += 1
                ones = 0
            else:
                ones += 1
                zeros = 0
            max_ones = max(max_ones, ones)
            max_zeros = max(max_zeros, zeros)
        return max_ones > max_zeros