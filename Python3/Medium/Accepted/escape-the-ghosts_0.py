class Solution:
    def escapeGhosts(self, ghosts: List[List[int]], target: List[int]) -> bool:
        
        return all(abs(target[0] - g[0]) + abs(target[1] - g[1]) > abs(target[0]) + abs(target[1]) for g in ghosts)