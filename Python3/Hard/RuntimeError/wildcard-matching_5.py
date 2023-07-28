class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        
        # s = "aa", p = "a"
        # s = "aa", p = "*"
        # s = "cb", p = "?a"
        # s = "adceb", p = "*a*b"
        # s = "acdcb", p = "a*c?b"
        # s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", p = "a*******b"
        # s = "aa", p = "a*"
        # s = "ab", p = "?*"
        # s = "aab", p = "c*a*b"
        # s = "abefcdgiescdfimde", p = "ab*cd?i*de"
        # s = "mississippi", p = "m??*ss*?i*pi"
        # s = "ho", p = "ho**"
        # s = "ho", p = "**ho"