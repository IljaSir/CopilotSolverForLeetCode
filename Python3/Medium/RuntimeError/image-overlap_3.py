class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        
        def countOnes(x, y):
            count = 0
            for i in range(n):
                for j in range(n):
                    if img1[i][j] == 1 and img2[i+x][j+y] == 1:
                        count += 1
            return count
        n = len(img1)
        max_ones = 0
        for i in range(n):
            for j in range(n):
                max_ones = max(max_ones, countOnes(i, j))
                max_ones = max(max_ones, countOnes(-i, j))
                max_ones = max(max_ones, countOnes(i, -j))
                max_ones = max(max_ones, countOnes(-i, -j))
        return max_ones