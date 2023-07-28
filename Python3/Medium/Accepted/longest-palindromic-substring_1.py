class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        if not s:
            return s
        if len(s) == 1:
            return s
        if len(s) == 2:
            if s[0] == s[1]:
                return s
            else:
                return s[0]
        if len(s) == 3:
            if s[0] == s[2]:
                return s
            elif s[0] == s[1]:
                return s[0:2]
            elif s[1] == s[2]:
                return s[1:]
            else:
                return s[0]

        def expand_around_center(s, left, right):
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return s[left + 1: right]

        res = s[0]
        for i in range(0, len(s) - 1):
            palindrome_odd = expand_around_center(s, i, i)
            palindrome_even = expand_around_center(s, i, i + 1)
            if len(palindrome_odd) > len(res):
                res = palindrome_odd
            if len(palindrome_even) > len(res):
                res = palindrome_even
        return res