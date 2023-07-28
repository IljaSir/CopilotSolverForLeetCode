class Solution:
    def findComplement(self, num: int) -> int:
        
        # 1st solution
        # return int(''.join(['1' if x == '0' else '0' for x in bin(num)[2:]]), 2)
        # 2nd solution
        return num ^ (2 ** (len(bin(num)[2:])) - 1)