class Solution:
    def bitwiseComplement(self, n: int) -> int:
        
        if n == 0:
            return 1
        binary = bin(n)[2:]
        complement = ''
        for i in binary:
            if i == '0':
                complement += '1'
            else:
                complement += '0'
        return int(complement, 2)