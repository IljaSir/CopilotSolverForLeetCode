class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        
        n = len(img1)
        pos1 = [(i, j) for i in range(n) for j in range(n) if img1[i][j]]
        pos2 = [(i, j) for i in range(n) for j in range(n) if img2[i][j]]
        cnt = collections.Counter((i1-i2, j1-j2) for i1, j1 in pos1 for i2, j2 in pos2)
        return max(cnt.values() or [0])