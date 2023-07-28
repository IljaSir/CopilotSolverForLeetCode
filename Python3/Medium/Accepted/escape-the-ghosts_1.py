class Solution:
    def escapeGhosts(self, ghosts: List[List[int]], target: List[int]) -> bool:
        
        def dist(x, y):
            return abs(x[0] - y[0]) + abs(x[1] - y[1])
        return all(dist(ghost, target) > dist([0, 0], target) for ghost in ghosts)