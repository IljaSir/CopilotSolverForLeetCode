class Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        
        same = set()
        for i in range(len(fronts)):
            if fronts[i] == backs[i]:
                same.add(fronts[i])
        ans = 2001
        for i in range(len(fronts)):
            if fronts[i] not in same:
                ans = min(ans, fronts[i])
            if backs[i] not in same:
                ans = min(ans, backs[i])
        return ans if ans != 2001 else 0