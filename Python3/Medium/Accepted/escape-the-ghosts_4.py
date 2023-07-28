class Solution:
    def escapeGhosts(self, ghosts: List[List[int]], target: List[int]) -> bool:
        
        def dist(x, y):
            return abs(x[0] - y[0]) + abs(x[1] - y[1])
        d = dist([0, 0], target)
        return all(dist(g, target) > d for g in ghosts)