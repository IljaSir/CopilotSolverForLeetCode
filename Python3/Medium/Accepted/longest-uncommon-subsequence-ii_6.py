class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        
        def is_subsequence(s1, s2):
            if not s1:
                return True
            if not s2:
                return False
            if s1[0] == s2[0]:
                return is_subsequence(s1[1:], s2[1:])
            return is_subsequence(s1, s2[1:])
        for s in sorted(strs, key=len, reverse=True):
            if sum(is_subsequence(s, t) for t in strs) == 1:
                return len(s)
        return -1