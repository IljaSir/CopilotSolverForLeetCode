class Solution:
    def splitString(self, s: str) -> bool:
        
        def dfs(s, prev, diff):
            if not s:
                return True
            for i in range(1, len(s) + 1):
                cur = s[:i]
                if len(cur) > 1 and cur[0] == '0':
                    continue
                if int(cur) == prev - diff:
                    if dfs(s[i:], int(cur), diff):
                        return True
            return False
        for i in range(1, len(s)):
            if s[i] == '0':
                continue
            if dfs(s[i:], int(s[:i]), int(s[:i]) - int(s[i:])):
                return True
        return False