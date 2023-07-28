class Solution:
    def escapeGhosts(self, ghosts: List[List[int]], target: List[int]) -> bool:
        
        return all(abs(a - b) + abs(c - d) > abs(target[0] - target[1]) + abs(target[0] - target[1]) for a, b, c, d in ghosts)