class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        # # 1st solution: BFS
        # # 1. Initialize a queue to hold all 0s and a visited set
        # # 2. Loop through the queue, for each 0, set its value to 0
        # # 3. For each 0, loop through its 4 neighbors (up, down, left, right)
        # # 4. If the neighbor is 1 and not visited, add it to the queue and set its value to the current value + 1
        # # 5. After the loop, return the mat
        # if not mat or not mat[0]:
        #     return mat
        # m, n = len(mat), len(mat[0])
        # queue = collections.deque()
        # visited = set()
        # for i in range(m):
        #     for j in range(n):
        #         if mat[i][j] == 0:
        #             queue.append((i, j))
        #             visited.add((i, j))
        # while queue:
        #     x, y = queue.popleft()
        #     for x2, y2 in [(x-1, y), (x+1, y), (x, y-1), (x, y+1)]:
        #         if 0 <= x2 < m and 0 <= y2 < n and mat[x2][y2] == 1 and (x2, y2) not in visited:
        #             mat[x2][y2] = mat[x][y] + 1
        #             visited.add((x2, y2))
        #             queue.append((x2, y2))
        # return mat
        
        # 2nd solution: DP
        # 1. Initialize a dp matrix with all 0s
        # 2. Loop through the matrix, for each 1, set its value to the minimum of its left, up, right, and bottom neighbors + 1
        # 3. Loop through the matrix again, for each 1, set its value to the minimum of its left, up, right, and bottom neighbors + 1
        # 4. Return the dp matrix
        if not mat or not mat[0]:
            return mat
        m, n = len(mat), len(mat[0