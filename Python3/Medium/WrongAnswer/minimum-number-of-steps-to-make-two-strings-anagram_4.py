class Solution:
    def minSteps(self, s: str, t: str) -> int:
        
        s = list(s)
        t = list(t)
        s.sort()
        t.sort()
        s = ''.join(s)
        t = ''.join(t)
        print(s)
        print(t)
        count = 0
        for i in range(len(s)):
            if s[i] != t[i]:
                count += 1
        return count