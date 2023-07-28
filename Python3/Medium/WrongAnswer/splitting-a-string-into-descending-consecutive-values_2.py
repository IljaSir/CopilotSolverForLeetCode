class Solution:
    def splitString(self, s: str) -> bool:
        
        def dfs(s, pre):
            if not s: return True
            for i in range(1, len(s)+1):
                if i > 1 and s[0] == '0': break
                if int(s[:i]) == pre - 1:
                    if dfs(s[i:], int(s[:i])): return True
            return False
        for i in range(1, len(s)):
            if i > 1 and s[0] == '0': break
            if dfs(s[i:], int(s[:i])): return True
        return False