class Solution:
    def checkZeroOnes(self, s: str) -> bool:
        
        longest_0 = 0
        longest_1 = 0
        current_0 = 0
        current_1 = 0
        for i in range(len(s)):
            if s[i] == '0':
                current_0 += 1
                if current_1 > longest_1:
                    longest_1 = current_1
                current_1 = 0
            else:
                current_1 += 1
                if current_0 > longest_0:
                    longest_0 = current_0
                current_0 = 0
        if current_0 > longest_0:
            longest_0 = current_0
        if current_1 > longest_1:
            longest_1 = current_1
        return longest_1 > longest_0