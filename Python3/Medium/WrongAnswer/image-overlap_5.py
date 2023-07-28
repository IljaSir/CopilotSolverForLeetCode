class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        
        def findOverlap(img1, img2, x, y):
            m = len(img1)
            n = len(img1[0])
            count = 0
            for i in range(m):
                for j in range(n):
                    if img1[i][j] == 1 and img2[i+y][j+x] == 1:
                        count += 1
            return count
        m = len(img1)
        n = len(img1[0])
        img2 = [[0]*n*3 for _ in range(m*3)]
        for i in range(m):
            for j in range(n):
                img2[i+m][j+n] = img2[i][j] = img1[i][j]
        res = 0
        for y in range(m*2):
            for x in range(n*2):
                res = max(res, findOverlap(img1, img2, x, y))
        return res