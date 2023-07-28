class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        if not s:
            return []
        self.res = []
        self.dfs(s, [])
        return self.res