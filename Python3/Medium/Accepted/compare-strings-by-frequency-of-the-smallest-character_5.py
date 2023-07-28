class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        
        def f(s):
            return s.count(min(s))
        return [len([w for w in words if f(q) < f(w)]) for q in queries]