class Solution:
    def checkZeroOnes(self, s: str) -> bool:
        
        longest_1 = 0
        longest_0 = 0
        current_1 = 0
        current_0 = 0
        for c in s:
            if c == '0':
                current_0 += 1
                current_1 = 0
            else:
                current_1 += 1
                current_0 = 0
            if current_1 > longest_1:
                longest_1 = current_1
            if current_0 > longest_0:
                longest_0 = current_0
        return longest_1 > longest_0