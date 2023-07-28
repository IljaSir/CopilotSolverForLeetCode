class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        
        d = {}
        for w in words:
            d[w] = d.get(w, 0) + 1
        return [w for w, _ in sorted(d.items(), key=lambda x: (-x[1], x[0]))][:k]