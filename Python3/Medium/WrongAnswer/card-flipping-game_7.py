class Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        
        a = set(fronts)
        b = set(backs)
        c = a.intersection(b)
        for i in c:
            a.remove(i)
        if a:
            return min(a)
        else:
            return 0