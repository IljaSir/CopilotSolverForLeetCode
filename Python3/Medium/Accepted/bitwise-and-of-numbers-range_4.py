class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        
        if left == right:
            return left
        if left == 0:
            return 0
        if right-left == 1:
            return left & right
        return self.rangeBitwiseAnd(left >> 1, right >> 1) << 1