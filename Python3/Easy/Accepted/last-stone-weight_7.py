class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        
        from heapq import heapify, heappush, heappop
        stones = [-x for x in stones]
        heapify(stones)
        while len(stones) > 1:
            x = -heappop(stones)
            y = -heappop(stones)
            if x != y:
                heappush(stones, -(x - y))
        return -heappop(stones) if stones else 0