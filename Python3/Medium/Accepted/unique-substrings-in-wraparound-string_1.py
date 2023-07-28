class Solution:
    def findSubstringInWraproundString(self, s: str) -> int:
        
        if not s:
            return 0
        count = [0] * 26
        cur = 1
        for i in range(len(s)):
            if i > 0 and (ord(s[i]) - ord(s[i-1]) == 1 or s[i-1] == 'z' and s[i] == 'a'):
                cur += 1
            else:
                cur = 1
            count[ord(s[i]) - ord('a')] = max(count[ord(s[i]) - ord('a')], cur)
        return sum(count)