class Solution:
    def escapeGhosts(self, ghosts: List[List[int]], target: List[int]) -> bool:
        
        def dist(x,y):
            return abs(x-target[0])+abs(y-target[1])
        return all(dist(x,y)<=dist(0,0) for x,y in ghosts)