class Solution:
    def shortestPalindrome(self, s: str) -> str:
        
        def get_next(s):
            next = [-1] * len(s)
            i, j = 0, -1
            while i < len(s)-1:
                if j == -1 or s[i] == s[j]:
                    i += 1
                    j += 1
                    next[i] = j
                else:
                    j = next[j]
            return next
        next = get_next(s)
        i, j = 0, len(s)-1
        while i < j:
            if s[i] == s[j]:
                i += 1
                j -= 1
            else:
                if next[j] == -1:
                    i = 0
                else:
                    i = next[j]
                j = len(s)-1
        return s[len(s)-1:i-1:-1] + s