class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
        self.res = []
        self.dfs(s, [])
        return self.res