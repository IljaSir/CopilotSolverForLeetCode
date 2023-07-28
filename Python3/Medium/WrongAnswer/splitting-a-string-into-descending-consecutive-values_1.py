class Solution:
    def splitString(self, s: str) -> bool:
        
        def dfs(pos, prev):
            if pos == n:
                return True
            for i in range(pos, n):
                curr = int(s[pos:i+1])
                if prev - curr == 1:
                    if dfs(i+1, curr):
                        return True
            return False
        n = len(s)
        return dfs(1, int(s[0]))