class Solution:
    def maximumBinaryString(self, binary: str) -> str:
        
        n = len(binary)
        i = 0
        while i < n and binary[i] == '1':
            i += 1
        if i == n:
            return binary
        j = n - 1
        while j >= 0 and binary[j] == '0':
            j -= 1
        if j == 0:
            return '1' * (n - 1) + '0'
        return '1' * (i + 1) + '0' * (n - j - 2) + '1'