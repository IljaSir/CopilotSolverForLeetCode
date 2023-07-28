class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        
        q = [0]
        visited = set([0])
        while q:
            i = q.pop(0)
            for j in rooms[i]:
                if j not in visited:
                    q.append(j)
                    visited.add(j)
        return len(visited) == len(rooms)