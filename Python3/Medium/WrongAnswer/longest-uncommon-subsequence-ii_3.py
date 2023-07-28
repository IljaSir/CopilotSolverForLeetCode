class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        
        def isSubseq(s1, s2):
            i = 0
            for c in s2:
                if i < len(s1) and s1[i] == c:
                    i += 1
            return i == len(s1)
        
        strs.sort(key=len, reverse=True)
        for i, s in enumerate(strs):
            if sum(isSubseq(s, s2) for s2 in strs if s != s2) == 0:
                return len(s)
        return -1