class Solution:
    def alternateDigitSum(self, n: int) -> int:
        
        s = str(n)
        sum = 0
        for i in range(len(s)):
            if i % 2 == 0:
                sum += int(s[i])
            else:
                sum -= int(s[i])
        return sum