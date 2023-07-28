class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        
        # print(left, right)
        if left == 0:
            return 0
        if left == right:
            return left
        if left == 1:
            return 0
        if right - left == 1:
            return left & right
        l = left.bit_length()
        r = right.bit_length()
        if l != r:
            return 0
        return self.rangeBitwiseAnd(left - 2**(l-1), right - 2**(l-1)) + 2**(l-1)