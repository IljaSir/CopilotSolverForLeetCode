class Solution:
    def isSameAfterReversals(self, num: int) -> bool:
        
        def reverse(x):
            return int(str(x)[::-1])
        return num == reverse(reverse(num))