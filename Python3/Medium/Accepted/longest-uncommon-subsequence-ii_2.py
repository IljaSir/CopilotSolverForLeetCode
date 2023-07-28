class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        
        def isSubsequence(a, b):
            i = 0
            for c in b:
                if i < len(a) and c == a[i]:
                    i += 1
            return i == len(a)
        strs.sort(key=len, reverse=True)
        for i, a in enumerate(strs):
            if all(not isSubsequence(a, b) for j, b in enumerate(strs) if i != j):
                return len(a)
        return -1