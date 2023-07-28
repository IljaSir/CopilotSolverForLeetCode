class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        
        n = len(img1)
        def shift(img, dx, dy):
            res = [[0] * n for _ in range(n)]
            for i in range(n):
                for j in range(n):
                    if 0 <= i + dx < n and 0 <= j + dy < n:
                        res[i+dx][j+dy] = img[i][j]
            return res
        def count_overlap(img1, img2):
            res = 0
            for i in range(n):
                for j in range(n):
                    res += img1[i][j] & img2[i][j]
            return res
        res = 0
        for dx in range(n):
            for dy in range(n):
                res = max(res, count_overlap(img1, shift(img2, dx, dy)))
                res = max(res, count_overlap(img2, shift(img1, dx, dy)))
        return res