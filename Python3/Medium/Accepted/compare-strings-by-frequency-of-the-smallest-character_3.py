class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        
        def f(s):
            return s.count(min(s))
        queries = [f(q) for q in queries]
        words = [f(w) for w in words]
        return [len([w for w in words if w > q]) for q in queries]