class Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        
        forbidden = set()
        for i in range(len(fronts)):
            if fronts[i] == backs[i]:
                forbidden.add(fronts[i])
        ans = float('inf')
        for i in range(len(fronts)):
            if fronts[i] not in forbidden:
                ans = min(ans, fronts[i])
            if backs[i] not in forbidden:
                ans = min(ans, backs[i])
        if ans == float('inf'):
            return 0
        return ans