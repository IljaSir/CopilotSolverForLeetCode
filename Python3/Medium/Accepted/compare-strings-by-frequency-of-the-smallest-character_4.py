class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        
        def f(s):
            return s.count(min(s))
        return [sum(f(queries[i]) < f(W) for W in words) for i in range(len(queries))]