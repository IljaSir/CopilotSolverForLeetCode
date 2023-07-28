class Solution:
    def findLexSmallestString(self, s: str, a: int, b: int) -> str:
        
        
        def rotate(s, b):
            return s[-b:] + s[:-b]
        
        def add(s, a):
            s = list(s)
            for i in range(1, len(s), 2):
                s[i] = str((int(s[i]) + a) % 10)
            return ''.join(s)
        
        def dfs(s, a, b, seen):
            if s in seen:
                return
            seen.add(s)
            self.ans = min(self.ans, s)
            dfs(rotate(s, b), a, b, seen)
            dfs(add(s, a), a, b, seen)
        
        self.ans = s
        dfs(s, a, b, set())
        return self.ans