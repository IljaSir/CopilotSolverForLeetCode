class Solution:
    def reorganizeString(self, s: str) -> str:
        
        count = collections.Counter(s)
        heap = [(-freq, char) for char, freq in count.items()]
        heapq.heapify(heap)
        if any(-freq > (len(s) + 1) // 2 for freq, char in count.items()):
            return ""
        result = []
        while len(heap) >= 2:
            freq1, char1 = heapq.heappop(heap)
            freq2, char2 = heapq.heappop(heap)
            result.extend([char1, char2])
            if freq1 + 1: heapq.heappush(heap, (freq1 + 1, char1))
            if freq2 + 1: heapq.heappush(heap, (freq2 + 1, char2))
        return "".join(result) + (heap[0][1] if heap else '')