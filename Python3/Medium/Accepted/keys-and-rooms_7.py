class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        
        n = len(rooms)
        visited = [0] * n
        def dfs(i):
            visited[i] = 1
            for j in rooms[i]:
                if visited[j] == 0:
                    dfs(j)
        dfs(0)
        return all(visited)