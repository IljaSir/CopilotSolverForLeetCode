class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        
        return [sum([1 for w in words if queries[i].count(min(queries[i])) < w.count(min(w))]) for i in range(len(queries))]