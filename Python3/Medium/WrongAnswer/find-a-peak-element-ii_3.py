class Solution:
    def findPeakGrid(self, mat: List[List[int]]) -> List[int]:
        
        m, n = len(mat), len(mat[0])
        def findPeak(i, j, k):
            if k == 1:
                return [i, j]
            mid = k // 2
            if mat[i][j] > mat[i][j+mid]:
                return findPeak(i, j, mid)
            else:
                return findPeak(i, j+mid, k-mid)
        def findMax(i, j, k):
            if k == 1:
                return [i, j]
            mid = k // 2
            if mat[i][j] > mat[i+mid][j]:
                return findMax(i, j, mid)
            else:
                return findMax(i+mid, j, k-mid)
        i, j = findMax(0, 0, m)
        return findPeak(i, 0, n)