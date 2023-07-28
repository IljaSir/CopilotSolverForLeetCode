class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        
        n = len(img1)
        l1 = [(i, j) for i in range(n) for j in range(n) if img1[i][j] == 1]
        l2 = [(i, j) for i in range(n) for j in range(n) if img2[i][j] == 1]
        d = {}
        for x1, y1 in l1:
            for x2, y2 in l2:
                d[(x2-x1, y2-y1)] = d.get((x2-x1, y2-y1), 0) + 1
        return max(d.values()) if d else 0