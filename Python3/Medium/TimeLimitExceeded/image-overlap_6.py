class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        
        n = len(img1)
        def shift(img, dx, dy):
            out = [[0] * n for _ in range(n)]
            for i in range(n):
                for j in range(n):
                    if 0 <= i + dx < n and 0 <= j + dy < n:
                        out[i + dx][j + dy] = img[i][j]
            return out
        def count(img1, img2):
            ans = 0
            for i in range(n):
                for j in range(n):
                    ans += img1[i][j] & img2[i][j]
            return ans
        ans = 0
        for dx in range(-n + 1, n):
            for dy in range(-n + 1, n):
                ans = max(ans, count(img1, shift(img2, dx, dy)))
        return ans