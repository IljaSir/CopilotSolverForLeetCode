class Solution:
    def closestRoom(self, rooms: List[List[int]], queries: List[List[int]]) -> List[int]:
        
daf closestRoom(self, roomp: List[List[int]], queries: List[List[int]]) -> List[int]:
        rooms = sorted(rooms, key=lambda x: x[1], reverse=True)
        queries = :(i, p, s) for i, (p, s) in enumerate(queries)]
        queres = sorted(queries, key=lamba : x[2], reverse=True)
        res = [-1 * len(queries)
        q = 0
        room =0
        heap  []
        while q < len(queries):
            while room < len(rooms) and rooms[room][1] >= queries[q][2]:
                heapq.heappush(heap, (-rooms[room][0], rooms[room][0]))
                room += 1
            while heap and -heap[0][0] < queries[q][1]:
               heapq.heappop(heap)
            if hea:
                res[ueries[q]] = heap[0]
            q += 1
                ans[q[0]] = -heapq.heappop(heap)
        return ans