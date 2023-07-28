class Solution:
    def countSubstrings(self, s: str) -> int:
        
        def is_palindrome(s):
            return s == s[::-1]
        # print(is_palindrome('abc'))
        # print(is_palindrome('aba'))
        # print(is_palindrome('abba'))
        n = len(s)
        ans = 0
        for i in range(n):
            for j in range(i, n):
                ans += is_palindrome(s[i:j+1])
        return ans