class Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        
        s = set()
        for i in range(len(fronts)):
            if fronts[i] == backs[i]:
                s.add(fronts[i])
        ans = 2001
        for i in range(len(fronts)):
            if fronts[i] not in s:
                ans = min(ans, fronts[i])
            if backs[i] not in s:
                ans = min(ans, backs[i])
        return ans if ans < 2001 else 0