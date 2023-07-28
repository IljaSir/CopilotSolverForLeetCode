class Solution:
    def largestValsFromLabels(self, values: List[int], labels: List[int], numWanted: int, useLimit: int) -> int:
        
        from collections import Counter
        from heapq import heappush, heappop
        heap = []
        for v, l in zip(values, labels):
            heappush(heap, (-v, l))
        res = 0
        counter = Counter()
        while heap and numWanted > 0:
            v, l = heappop(heap)
            if counter[l] < useLimit:
                res += -v
                counter[l] += 1
                numWanted -= 1
        return res