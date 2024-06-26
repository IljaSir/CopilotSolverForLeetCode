class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        
        def isSubsequence(s, t):
            i = j = 0
            while i < len(s) and j < len(t):
                if s[i] == t[j]:
                    i += 1
                j += 1
            return i == len(s)
        strs.sort(key=lambda x: len(x), reverse=True)
        for i, s in enumerate(strs):
            if all(not isSubsequence(s, t) for j, t in enumerate(strs) if i != j):
                return len(s)
        return -1