class Solution:
    def monotoneIncreasingDigits(self, n: int) -> int:
        
        s = str(n)
        for i in range(len(s)-1):
            if s[i] > s[i+1]:
                return int(s[:i] + str(int(s[i])-1) + '9'*(len(s)-i-1))
        return n