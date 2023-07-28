class Solution:
    def expressiveWords(self, s: str, words: List[str]) -> int:
        
        
        def check(s, t):
            if len(s) < len(t):
                return False
            i, j = 0, 0
            while i < len(s) and j < len(t):
                if s[i] == t[j]:
                    i += 1
                    j += 1
                elif i > 0 and s[i] == s[i - 1] and s[i] == s[i + 1]:
                    i += 1
                else:
                    return False
            return j == len(t)
        
        res = 0
        for word in words:
            if check(s, word):
                res += 1
        return res