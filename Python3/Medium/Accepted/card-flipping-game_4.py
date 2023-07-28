class Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        
        same = set()
        for f, b in zip(fronts, backs):
            if f == b:
                same.add(f)
        return min([x for x in fronts + backs if x not in same] or [0])