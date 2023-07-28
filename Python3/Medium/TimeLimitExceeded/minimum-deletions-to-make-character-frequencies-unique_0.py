class Solution:
    def minDeletions(self, s: str) -> int:
        
        from collections import Counter
        from heapq import heappush, heappop
        counter = Counter(s)
        heap = []
        for c, cnt in counter.items():
            heappush(heap, (-cnt, c))
        deleted = 0
        while heap:
            cnt, c = heappop(heap)
            while heap and heap[0][0] == cnt:
                cnt, c = heappop(heap)
                deleted += 1
                cnt += 1
            if cnt < 0:
                heappush(heap, (cnt, c))
        return deleted