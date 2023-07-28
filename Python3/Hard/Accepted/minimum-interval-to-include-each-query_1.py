class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        
        
        intervals.sort()
        queries = [(q, i) for i, q in enumerate(queries)]
        queries.sort()
        
        ans = [-1] * len(queries)
        heap = []
        i = 0
        for q, idx in queries:
            while i < len(intervals) and intervals[i][0] <= q:
                heapq.heappush(heap, (intervals[i][1] - intervals[i][0] + 1, intervals[i][1]))
                i += 1
            while heap and heap[0][1] < q:
                heapq.heappop(heap)
            if heap:
                ans[idx] = heap[0][0]
        return ans