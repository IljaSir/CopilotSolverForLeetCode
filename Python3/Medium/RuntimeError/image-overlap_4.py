class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        
        def shift(a, b):
            n = len(a)
            cnt = 0
            for i in range(n):
                for j in range(n):
                    if a[i][j] == 1 and b[i][j] == 1:
                        cnt += 1
            return cnt
        n = len(img1)
        res = 0
        for i in range(n):
            for j in range(n):
                tmp1 = [[0] * n for _ in range(n)]
                tmp2 = [[0] * n for _ in range(n)]
                for x in range(i, n):
                    for y in range(j, n):
                        tmp1[x][y] = img1[x - i][y - j]
                for x in range(n - i):
                    for y in range(n - j):
                        tmp2[x][y] = img2[x + i][y + j]
                res = max(res, shift(tmp1, tmp2))
        for i in range(n):
            for j in range(n):
                tmp1 = [[0] * n for _ in range(n)]
                tmp2 = [[0] * n for _ in range(n)]
                for x in range(i, n):
                    for y in range(j):
                        tmp1[x][y] = img1[x - i][n - j + y]
                for x in range(n - i):
                    for y in range(j):
                        tmp2[x][y] = img2[x + i][y]
                res = max(res, shift(tmp1, tmp2))
        for i in range(n):
            for j in range(n):
                tmp1 = [[0] * n for _ in range(n)]
                tmp2 = [[0] * n for _ in range(n)]
                for x in range(i):
                    for y in range(j, n):
                        tmp1[x][y] = img1[n - i + x][y - j]
                for x in range(i):
                    for y in range(n - j):
                        tmp2[x][y] = img2[x][y + j]
                res = max(res, shift(tmp1, tmp2))
        for i in range(n):
            for j in range(n):
                tmp1 = [[0] * n for _ in range(n)]
                tmp2 = [[0] * n for _ in range(n)]