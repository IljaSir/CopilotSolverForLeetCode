class Solution:
    def longestNiceSubstring(self, s: str) -> str:
        
        
        # if len(s) == 1:
        #     return ""
        # if len(s) == 2:
        #     if s[0].lower() == s[1].lower():
        #         return s
        #     else:
        #         return ""
        
        # for i in range(len(s)-1):
        #     if s[i].lower() == s[i+1].lower():
        #         return s[i:i+2]
        # return ""
        def is_nice(s):
            return all(c.lower() in s and c.upper() in s for c in string.ascii_lowercase)
        for i in range(len(s), 0, -1):
            for j in range(len(s) - i + 1):
                if is_nice(s[j:j+i]):
                    return s[j:j+i]
        return ""