class Solution:
    def reorganizeString(self, s: str) -> str:
        
        count = collections.Counter(s)
        heap = [(-freq, char) for char, freq in count.items()]
        heapq.heapify(heap)
        res = []
        while len(heap) > 1:
            freq1, char1 = heapq.heappop(heap)
            freq2, char2 = heapq.heappop(heap)
            res.extend([char1, char2])
            if freq1 + 1:
                heapq.heappush(heap, (freq1 + 1, char1))
            if freq2 + 1:
                heapq.heappush(heap, (freq2 + 1, char2))
        return ''.join(res) + (heap[0][1] if heap else '')