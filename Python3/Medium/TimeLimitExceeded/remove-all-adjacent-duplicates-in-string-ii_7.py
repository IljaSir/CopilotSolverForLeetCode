class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        
        while True:
            found = False
            for i in range(len(s) - k + 1):
                if s[i] * k == s[i:i+k]:
                    found = True
                    s = s[:i] + s[i+k:]
                    break
            if not found:
                break
        return s