class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        
        m, n = len(mat), len(mat[0])
        res = []
        for i in range(m+n-1):
            if i % 2 == 0:
                for j in range(i, -1, -1):
                    if j >= m or i-j >= n:
                        continue
                    res.append(mat[j][i-j])
            else:
                for j in range(i+1):
                    if j >= m or i-j >= n:
                        continue
                    res.append(mat[j][i-j])
        return res