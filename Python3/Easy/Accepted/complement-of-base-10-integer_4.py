class Solution:
    def bitwiseComplement(self, n: int) -> int:
        
        if n == 0:
            return 1
        return int("".join(['0' if x == '1' else '1' for x in "{0:b}".format(n)]), 2)