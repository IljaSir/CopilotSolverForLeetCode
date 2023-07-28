class Solution:
    def containVirus(self, isInfected: List[List[int]]) -> int:
        
        m, n = len(isInfected), len(isInfected[0])
        def get_neighbors(i, j):
            for x, y in ((i-1, j), (i+1, j), (i, j-1), (i, j+1)):
                if 0 <= x < m and 0 <= y < n:
                    yield x, y
        def bfs(i, j):
            q = [(i, j)]
            virus = set()
            empty = set()
            while q:
                i, j = q.pop()
                if (i, j) in virus:
                    continue
                virus.add((i, j))
                for x, y in get_neighbors(i, j):
                    if isInfected[x][y] == 1:
                        q.append((x, y))
                    elif isInfected[x][y] == 0:
                        empty.add((x, y))
            return virus, empty
        def get_contagion(virus):
            return sum(1 for i, j in virus if isInfected[i][j] == 0)
        def get_walls(virus):
            return sum(1 for i, j in virus if isInfected[i][j] == 1)
        def infect(virus):
            for i, j in virus:
                isInfected[i][j] = 1
        ans = 0
        while True:
            max_contagion = 0
            max_virus = None
            max_walls = 0
            for i in range(m):
                for j in range(n):
                    if isInfected[i][j] == 1:
                        virus, empty = bfs(i, j)
                        contagion = get_contagion(virus)
                        walls = get_walls(virus)
                        if contagion > max_contagion:
                            max_contagion = contagion
                            max_virus = virus
                            max_walls = walls
                        elif contagion == max_contagion and walls > max_walls:
                            max_virus = virus
                            max_walls = walls
            if max_virus is None:
                break
            ans += max_walls
            infect(max_virus)
        return ans