class Solution:
    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        
        self.d = defaultdict(list)
        for t in allowed:
            self.d[t[:2]].append(t[2])
        return self.dfs(bottom, '')