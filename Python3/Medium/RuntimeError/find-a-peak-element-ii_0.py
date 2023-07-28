class Solution:
    def findPeakGrid(self, mat: List[List[int]]) -> List[int]:
        
        m, n = len(mat), len(mat[0])
        def get(i, j):
            if 0 <= i < m and 0 <= j < n:
                return mat[i][j]
            return -1
        def find(i, j, k, l):
            if k == l:
                return [i, k]
            mid = (k + l) // 2
            if get(i, mid) > get(i, mid + 1):
                return find(i, j, k, mid)
            return find(i, j, mid + 1, l)
        def find2(i, j, k, l):
            if k == l:
                return [k, j]
            mid = (k + l) // 2
            if get(mid, j) > get(mid + 1, j):
                return find2(i, j, k, mid)
            return find2(i, j, mid + 1, l)
        for i in range(m):
            if mat[i][0] > get(i, 1):
                return [i, 0]
            if mat[i][-1] > get(i, n - 2):
                return [i, n - 1]
        for j in range(n):
            if mat[0][j] > get(1, j):
                return [0, j]
            if mat[-1][j] > get(m - 2, j):
                return [m - 1, j]
        for i in range(1, m - 1):
            for j in range(1, n - 1):
                if mat[i][j] > get(i - 1, j) and mat[i][j] > get(i + 1, j) and mat[i][j] > get(i, j - 1) and mat[i][j] > get(i, j + 1):
                    return [i, j]
        for i in range(m):
            if mat[i][0] == get(i, 1):
                return find(i, 0, 0, n - 1)
        for i in range(m):
            if mat[i][-1] == get(i, n - 2):
                return find(i, n - 1, 0, n - 1)
        for j in range(n):
            if mat[