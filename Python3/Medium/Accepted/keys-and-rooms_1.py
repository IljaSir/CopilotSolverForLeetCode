class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        
        seen = set()
        stack = [0]
        while stack:
            node = stack.pop()
            seen.add(node)
            for nei in rooms[node]:
                if nei not in seen:
                    stack.append(nei)
        return len(seen) == len(rooms)