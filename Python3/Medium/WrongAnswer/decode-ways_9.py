class Solution:
    def numDecodings(self, s: str) -> int:
        
        if not s or s[0] == "0":
            return 0
        prev, curr = 0, 1
        for i in range(len(s)):
            if s[i] == "0":
                curr = 0
            if i > 0 and (s[i-1] == "1" or (s[i-1] == "2" and s[i] < "7")):
                prev, curr = curr, prev + curr
        return curr