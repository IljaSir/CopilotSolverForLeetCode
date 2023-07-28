class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        
        def f(s):
            return s.count(min(s))
        words = sorted([f(w) for w in words])
        return [len(words) - bisect.bisect(words, f(q)) for q in queries]