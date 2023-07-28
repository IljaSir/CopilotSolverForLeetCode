class Solution:
    def bitwiseComplement(self, n: int) -> int:
        
        if n == 0:
            return 1
        if n == 1:
            return 0
        binary_n = bin(n)[2:]
        complement = ''
        for i in range(len(binary_n)):
            if binary_n[i] == '0':
                complement += '1'
            else:
                complement += '0'
        return int(complement, 2)