class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        
        n = len(rooms)
        visited = [0] * n
        visited[0] = 1
        def dfs(i):
            for j in rooms[i]:
                if not visited[j]:
                    visited[j] = 1
                    dfs(j)
        dfs(0)
        return all(visited)