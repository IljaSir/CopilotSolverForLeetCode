class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        
        def freq(s):
            return s.count(min(s))
        return [sum(freq(q) < freq(w) for w in words) for q in queries]