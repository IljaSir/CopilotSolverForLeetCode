class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        n = len(s)
        if n == 1:
            return s
        elif n == 2:
            if s[0] == s[1]:
                return s
            else:
                return s[0]
        else:
            start = 0
            end = 0
            max_len = 0
            for i in range(n):
                if i - max_len >= 1 and s[i-max_len-1:i+1] == s[i-max_len-1:i+1][::-1]:
                    start = i - max_len - 1
                    end = i + 1
                    max_len += 2
                if i - max_len >= 0 and s[i-max_len:i+1] == s[i-max_len:i+1][::-1]:
                    start = i - max_len
                    end = i + 1
                    max_len += 1
            return s[start:end]