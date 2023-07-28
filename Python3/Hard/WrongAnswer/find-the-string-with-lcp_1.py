class Solution:
    def findTheString(self, lcp: List[List[int]]) -> str:
        
        n = len(lcp)
        s = [None] * n
        for i in range(n):
            for j in range(i + 1, n):
                if lcp[i][j] == n - max(i, j):
                    s[i] = s[j] = 0
        for i in range(n):
            for j in range(i + 1, n):
                if lcp[i][j] > 0:
                    if s[i] is None:
                        s[i] = s[j] + 1
                    elif s[j] is None:
                        s[j] = s[i] + 1
                    elif s[i] + 1 != s[j]:
                        return ""
        for i in range(n):
            if s[i] is None:
                s[i] = 0
        return "".join(chr(ord("a") + x) for x in s)