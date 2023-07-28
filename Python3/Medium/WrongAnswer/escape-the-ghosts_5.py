class Solution:
    def escapeGhosts(self, ghosts: List[List[int]], target: List[int]) -> bool:
        
        def distance(p1,p2):
            return abs(p1[0]-p2[0])+abs(p1[1]-p2[1])
        return all(distance(ghost,target)>=distance([0,0],target) for ghost in ghosts)