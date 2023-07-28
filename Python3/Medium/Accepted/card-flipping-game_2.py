class Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        
        seen = set()
        for i in range(len(fronts)):
            if fronts[i] == backs[i]:
                seen.add(fronts[i])
        res = 2001
        for i in range(len(fronts)):
            if fronts[i] not in seen:
                res = min(res, fronts[i])
            if backs[i] not in seen:
                res = min(res, backs[i])
        return res if res < 2001 else 0