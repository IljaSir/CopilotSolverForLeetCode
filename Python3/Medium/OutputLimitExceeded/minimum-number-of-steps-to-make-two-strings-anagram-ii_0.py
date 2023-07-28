class Solution:
    def minSteps(self, s: str, t: str) -> int:
        
        s = list(s)
        t = list(t)
        s.sort()
        t.sort()
        print(s)
        print(t)
        if s == t:
            return 0
        i = 0
        j = 0
        count = 0
        while i < len(s) and j < len(t):
            if s[i] == t[j]:
                i += 1
                j += 1
            elif s[i] < t[j]:
                i += 1
                count += 1
            elif s[i] > t[j]:
                j += 1
                count += 1
        while i < len(s):
            count += 1
            i += 1
        while j < len(t):
            count += 1
            j += 1
        return count