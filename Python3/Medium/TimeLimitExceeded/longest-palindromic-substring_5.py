class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        def is_palindrome(s):
            return s == s[::-1]
        n = len(s)
        max_len = 0
        ans = ''
        for i in range(n):
            for j in range(i, n):
                if is_palindrome(s[i:j+1]) and j - i + 1 > max_len:
                    max_len = j - i + 1
                    ans = s[i:j+1]
        return ans