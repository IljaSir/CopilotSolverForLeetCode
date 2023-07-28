class Solution:
    def reorganizeString(self, s: str) -> str:
        
        from collections import Counter
        counter = Counter(s)
        heap = [(-freq, char) for char, freq in counter.items()]
        heapq.heapify(heap)
        res = []
        while heap:
            freq, char = heapq.heappop(heap)
            if not res or res[-1] != char:
                res.append(char)
                if freq < -1:
                    heapq.heappush(heap, (freq+1, char))
            else:
                if not heap:
                    return ""
                freq2, char2 = heapq.heappop(heap)
                res.append(char2)
                if freq < -1:
                    heapq.heappush(heap, (freq+1, char))
                heapq.heappush(heap, (freq2, char))
        return "".join(res)