class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        
        n = len(img1)
        ones1 = []
        ones2 = []
        for i in range(n):
            for j in range(n):
                if img1[i][j] == 1:
                    ones1.append([i, j])
                if img2[i][j] == 1:
                    ones2.append([i, j])
        if len(ones1) == 0 or len(ones2) == 0:
            return 0
        counts = {}
        for x1, y1 in ones1:
            for x2, y2 in ones2:
                dx = x2 - x1
                dy = y2 - y1
                counts[(dx, dy)] = counts.get((dx, dy), 0) + 1
        return max(counts.values())