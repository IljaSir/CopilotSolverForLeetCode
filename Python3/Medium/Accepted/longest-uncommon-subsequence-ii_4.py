class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        
        def isSubsequence(s, t):
            it = iter(t)
            return all(c in it for c in s)
        strs.sort(key=len, reverse=True)
        for i, s in enumerate(strs):
            if all(not isSubsequence(s, t) for j, t in enumerate(strs) if i != j):
                return len(s)
        return -1