class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        
        def f(s):
            return s.count(min(s))
        return [sum(f(q) < f(w) for w in words) for q in queries]