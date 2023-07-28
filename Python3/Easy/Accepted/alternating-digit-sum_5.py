class Solution:
    def alternateDigitSum(self, n: int) -> int:
        
        s = str(n)
        sign = 1
        result = 0
        for i in range(len(s)):
            result += sign * int(s[i])
            sign *= -1
        return result