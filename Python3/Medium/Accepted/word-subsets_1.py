class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        
        d = {}
        for w in words2:
            for c in set(w):
                d[c] = max(d.get(c, 0), w.count(c))
        return [w for w in words1 if all(w.count(c) >= d[c] for c in d)]