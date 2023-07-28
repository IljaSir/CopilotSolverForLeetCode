class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        
        if left == 0:
            return 0
        left_bit = left.bit_length()
        right_bit = right.bit_length()
        if left_bit != right_bit:
            return 0
        for i in range(left_bit):
            if left & (1 << i) != right & (1 << i):
                return 0
        return left