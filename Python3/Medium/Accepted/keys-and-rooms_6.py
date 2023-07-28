class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        
        def dfs(i):
            if i in seen:
                return
            seen.add(i)
            for j in rooms[i]:
                dfs(j)
        seen = set()
        dfs(0)
        return len(seen) == len(rooms)