class Solution:
    def longestPalindrome(self, s: str) -> str:
        
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
        if len(s) == 4:
            if s[0] == s[3]:
                return s
            elif s[0] == s[2]:
                return s[0:3]
            elif s[0] == s[1]:
                return s[0:2]
            elif s[1] == s[3]:
                return s[1:4]
            elif s[1] == s[2]:
                return s[1:3]
            else:
                return s[1]
        if len(s) == 5:
            if s[0] == s[4]:
                return s
            elif s[0] == s[3]:
                return s[0:4]
            elif s[0] == s[2]:
                return s[0:3]
            elif s[0] == s[1]:
                return s[0:2]
            elif s[1] == s[4]:
                return s[1:5]
            elif s[1] == s[3]:
                return s[1:4]
            elif s[1] == s[2]:
                return s[1:3]
            elif s[2] == s[4]:
                return s[2:5]
            elif s[2] == s[3]:
                return s[2:4]
            else:
                return s[2]
        if len(s) == 6:
            if s[0] == s[5]:
                return s
            elif s[0] == s[4]:
                return s[0:5]
            elif s[0] == s[3]:
                return s[0:4]
            elif s[0] == s[2]:
                return s[0:3]
            elif s[0] == s[