class Solution:
    def escapeGhosts(self, ghosts: List[List[int]], target: List[int]) -> bool:
        
        def dist(pt):
            return abs(pt[0]-target[0])+abs(pt[1]-target[1])
        return dist([0, 0]) < min(dist(pt) for pt in ghosts)