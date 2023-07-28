class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        
        seen = set()
        def dfs(i):
            if i not in seen:
                seen.add(i)
                for j in rooms[i]:
                    dfs(j)
        dfs(0)
        return len(seen) == len(rooms)