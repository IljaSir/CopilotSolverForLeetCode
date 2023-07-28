class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        
        n = len(img1)
        def shift(a, b):
            return sum(img1[i+a][j+b] & img2[i][j] for i in range(n) for j in range(n))
        return max(shift(a, b) for a in range(-n+1, n) for b in range(-n+1, n))