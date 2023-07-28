class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        
        def shift(i, j):
            return sum(img1[i+di][j+dj] & img2[di][dj]
                       for di in range(n-i)
                       for dj in range(n-j))
        n = len(img1)
        return max(shift(i, j) for i in range(n) for j in range(n))