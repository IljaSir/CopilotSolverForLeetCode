class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        
        strs.sort(key=len, reverse=True)
        for i, s1 in enumerate(strs):
            if all(not self.isSubsequence(s1, s2) for j, s2 in enumerate(strs) if i != j):
                return len(s1)
        return -1