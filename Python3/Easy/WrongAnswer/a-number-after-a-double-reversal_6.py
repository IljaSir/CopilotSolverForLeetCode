class Solution:
    def isSameAfterReversals(self, num: int) -> bool:
        
        if num == 0:
            return True
        if num < 0:
            num = -num
        s = str(num)
        i = 0
        while i < len(s) // 2:
            if s[i] != s[-i - 1]:
                return False
            i += 1
        return True