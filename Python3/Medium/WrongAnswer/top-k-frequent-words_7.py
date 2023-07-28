class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        
        return [word for word, _ in collections.Counter(words).most_common(k)]