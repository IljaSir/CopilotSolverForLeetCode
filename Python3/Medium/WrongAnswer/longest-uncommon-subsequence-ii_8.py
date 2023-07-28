class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        
        if len(strs) == 1:
            return len(strs[0])
        strs.sort(key=lambda x: len(x), reverse=True)
        for i in range(len(strs)):
            if i == 0:
                if strs[i] != strs[i+1]:
                    return len(strs[i])
            elif i == len(strs)-1:
                if strs[i] != strs[i-1]:
                    return len(strs[i])
            else:
                if strs[i] != strs[i-1] and strs[i] != strs[i+1]:
                    return len(strs[i])
        return -1