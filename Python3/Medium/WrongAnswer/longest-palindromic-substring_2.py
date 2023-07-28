class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        if len(s) == 1:
            return s
        if len(s) == 2:
            if s[0] == s[1]:
                return s
            else:
                return s[0]
        # s = 'cbbd'
        # s = 'babad'
        # s = 'a'
        # s = 'ac'
        # s = 'bb'
        # s = 'ccc'
        # s = 'abba'
        # s = 'abcb'
        # s = 'abcba'
        # s = 'abccba'
        # s = 'abccbab'
        # s = 'abccbaa'
        # s = 'abccbaab'
        # s = 'abccbaabb'
        # s = 'abccbaabbb'
        # s = 'abccbaabbbb'
        # s = 'abccbaabbbbc'
        # s = 'abccbaabbbbbc'
        # s = 'abccbaabbbbbbc'
        # s = 'abccbaabbbbbbbc'
        # s = 'abccbaabbbbbbbbc'
        # s = 'abccbaabbbbbbbbbc'