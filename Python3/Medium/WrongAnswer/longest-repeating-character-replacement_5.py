class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        if len(s) == 1:
            return 1
        i = 0
        j = 0
        m = 0
        maxLen = 0
        while j < len(s):
            if s[j] == s[i]:
                j += 1
            else:
                if m < k:
                    m += 1
                    j += 1
                else:
                    maxLen = max(maxLen, j - i)
                    i += 1
        maxLen = max(maxLen, j - i)
        return maxLen