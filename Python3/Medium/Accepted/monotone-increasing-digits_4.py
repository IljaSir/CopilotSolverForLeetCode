class Solution:
    def monotoneIncreasingDigits(self, n: int) -> int:
        
        s = str(n)
        for i in range(len(s)-1,0,-1):
            if s[i] < s[i-1]:
                s = s[:i-1] + str(int(s[i-1])-1) + '9'*(len(s)-i)
        return int(s)