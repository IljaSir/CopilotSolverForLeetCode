class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        
        if not matrix:
            return []
        m, n = len(matrix), len(matrix[0])
        ans = []
        seen = [[False] * n for _ in range(m)]
        def dfs(i, j, di, dj):
            if seen[i][j]:
                return
            ans.append(matrix[i][j])
            seen[i][j] = True
            if 0 <= i + di < m and 0 <= j + dj < n and not seen[i + di][j + dj]:
                dfs(i + di, j + dj, di, dj)
            else:
                dfs(j, m - i - 1, dj, -di)
        dfs(0, 0, 0, 1)
        return ans