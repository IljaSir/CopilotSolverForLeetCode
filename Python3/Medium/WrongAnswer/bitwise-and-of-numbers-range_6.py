class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        
        if left == 0:
            return 0
        if left == right:
            return left
        if left & right == 0:
            return 0
        power = 31
        while power >= 0:
            if left & (1 << power) and right & (1 << power):
                break
            power -= 1
        return (1 << (power + 1)) - 1 & left