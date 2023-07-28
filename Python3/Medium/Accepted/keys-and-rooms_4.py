class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        
        visited = set()
        stack = [0]
        while stack:
            r = stack.pop()
            if r not in visited:
                visited.add(r)
                stack.extend(rooms[r])
        return len(visited) == len(rooms)