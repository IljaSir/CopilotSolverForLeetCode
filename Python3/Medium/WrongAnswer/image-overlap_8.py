class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        
        n = len(img1)
        def shift(l, r, d, u):
            res = 0
            for i in range(n):
                for j in range(n):
                    if 0 <= i+d < n and 0 <= j+r < n:
                        res += img1[i+d][j+r] * img2[i][j]
            return res
        res = 0
        for l in range(n):
            for r in range(n):
                for d in range(n):
                    for u in range(n):
                        res = max(res, shift(l, r, d, u))
        return res