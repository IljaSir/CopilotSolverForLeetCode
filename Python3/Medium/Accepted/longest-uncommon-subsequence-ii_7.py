class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        
        def isSubsequence(s1, s2):
            if len(s1) > len(s2):
                return False
            i = 0
            for c in s2:
                if i < len(s1) and s1[i] == c:
                    i += 1
            return i == len(s1)
        strs.sort(key = len, reverse = True)
        for i in range(len(strs)):
            if i == 0 or strs[i] != strs[i - 1]:
                if all(not isSubsequence(strs[i], strs[j]) for j in range(len(strs)) if i != j):
                    return len(strs[i])
        return -1