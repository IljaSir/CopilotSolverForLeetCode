class Solution:
    def reorganizeString(self, s: str) -> str:
        
        count = collections.Counter(s)
        heap = [(-cnt, char) for char, cnt in count.items()]
        heapq.heapify(heap)
        result = []
        while len(heap) >= 2:
            cnt1, char1 = heapq.heappop(heap)
            cnt2, char2 = heapq.heappop(heap)
            result.extend([char1, char2])
            if cnt1 + 1:
                heapq.heappush(heap, (cnt1 + 1, char1))
            if cnt2 + 1:
                heapq.heappush(heap, (cnt2 + 1, char2))
        if heap:
            cnt1, char1 = heapq.heappop(heap)
            if cnt1 + 1:
                return ""
            result.append(char1)
        return "".join(result)