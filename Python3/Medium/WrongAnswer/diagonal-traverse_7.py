class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        
        m, n = len(mat), len(mat[0])
        ans = []
        for i in range(m+n-1):
            if i % 2 == 1:
                for j in range(max(0, i-n+1), min(i+1, m)):
                    ans.append(mat[j][i-j])
            else:
                for j in range(min(i, m-1), max(0, i-n), -1):
                    ans.append(mat[j][i-j])
        return ans