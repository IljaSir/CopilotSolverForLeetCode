class Solution:
    def escapeGhosts(self, ghosts: List[List[int]], target: List[int]) -> bool:
        
        def get_dis(pos):
            return abs(pos[0] - target[0]) + abs(pos[1] - target[1])
        dis = get_dis([0, 0])
        for g in ghosts:
            if get_dis(g) <= dis:
                return False
        return True