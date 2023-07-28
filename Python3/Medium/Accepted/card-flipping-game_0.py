class Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        
        s = set()
        for i in range(len(fronts)):
            if fronts[i] == backs[i]:
                s.add(fronts[i])
        res = float('inf')
        for i in range(len(fronts)):
            if fronts[i] not in s:
                res = min(res, fronts[i])
            if backs[i] not in s:
                res = min(res, backs[i])
        return res if res != float('inf') else 0