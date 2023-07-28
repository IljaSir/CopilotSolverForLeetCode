class Solution:
    def removeDuplicates(self, s: str) -> str:
        
        s = list(s)
        while True:
            i = 0
            while i < len(s) - 1:
                if s[i] == s[i + 1]:
                    s.pop(i)
                    s.pop(i)
                    break
                i += 1
            else:
                return "".join(s)