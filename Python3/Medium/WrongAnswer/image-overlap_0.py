class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        
        n = len(img1)
        A = [i * n + j for i in range(n) for j in range(n) if img1[i][j]]
        B = [i * n + j for i in range(n) for j in range(n) if img2[i][j]]
        return max(collections.Counter(x - y for x in A for y in B).values() or [0])