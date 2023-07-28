class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        
        def isSubsequence(s: str, t: str) -> bool:
            it = iter(t)
            return all(c in it for c in s)
        
        strs.sort(key=len, reverse=True)
        for i, s in enumerate(strs):
            if sum(isSubsequence(s, t) for t in strs) == 1:
                return len(s)
        return -1