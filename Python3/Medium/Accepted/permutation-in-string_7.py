class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        
        n = len(s1)
        m = len(s2)
        if n > m:
            return False
        s1c = [0] * 26
        s2c = [0] * 26
        for i in range(n):
            s1c[ord(s1[i]) - ord('a')] += 1
            s2c[ord(s2[i]) - ord('a')] += 1
        for i in range(n, m):
            if s1c == s2c:
                return True
            s2c[ord(s2[i - n]) - ord('a')] -= 1
            s2c[ord(s2[i]) - ord('a')] += 1
        return s1c == s2c