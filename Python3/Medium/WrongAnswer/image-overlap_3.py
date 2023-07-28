class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        
        n = len(img1)
        img1 = [i for i in range(n) for j in range(n) if img1[i][j]]
        img2 = [i for i in range(n) for j in range(n) if img2[i][j]]
        d = collections.Counter([(i1 - i2, j1 - j2) for i1 in img1 for j1 in img1 for i2 in img2 for j2 in img2])
        return max(d.values() or [0])