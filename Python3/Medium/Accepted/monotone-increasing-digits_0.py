class Solution:
    def monotoneIncreasingDigits(self, n: int) -> int:
        
        s = str(n)
        i = 1
        while i < len(s) and s[i-1] <= s[i]:
            i += 1
        if i < len(s):
            while i > 0 and s[i-1] > s[i]:
                s = s[:i-1] + str(int(s[i-1])-1) + '9'*(len(s)-i)
                i -= 1
        return int(s)