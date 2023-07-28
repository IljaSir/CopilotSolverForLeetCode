class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        
        import heapq
        from collections import Counter
        heap = []
        for word, count in Counter(words).items():
            heapq.heappush(heap, (-count, word))
        return [heapq.heappop(heap)[1] for _ in range(k)]