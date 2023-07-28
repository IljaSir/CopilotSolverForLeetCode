class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        
        def isSubsequence(s1, s2):
            i = 0
            for c in s2:
                if i < len(s1) and c == s1[i]:
                    i += 1
            return i == len(s1)
        strs.sort(key=len, reverse=True)
        for i, s1 in enumerate(strs):
            if all(not isSubsequence(s1, s2) for j, s2 in enumerate(strs) if i != j):
                return len(s1)
        return -1