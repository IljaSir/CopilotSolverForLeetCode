class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        
        if not strs:
            return ""
        if len(strs) == 1:
            return strs[0]
        prefix = strs[0]
        for i in range(1, len(strs)):
            prefix = self.find_prefix(prefix, strs[i])
        return prefix