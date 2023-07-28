class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        
        from collections import Counter
        return [w[0] for w in Counter(words).most_common(k)]