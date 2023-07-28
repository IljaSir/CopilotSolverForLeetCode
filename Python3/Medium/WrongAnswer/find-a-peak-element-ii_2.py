class Solution:
    def findPeakGrid(self, mat: List[List[int]]) -> List[int]:
        
        m, n = len(mat), len(mat[0])
        def find(i, j, k):
            if i > j:
                return None
            mid = (i + j) // 2
            max_val = -1
            max_idx = -1
            for idx in range(max(0, mid - k), min(n, mid + k + 1)):
                if mat[mid][idx] > max_val:
                    max_val = mat[mid][idx]
                    max_idx = idx
            if mid - 1 >= 0 and mat[mid - 1][max_idx] > max_val:
                return find(i, mid - 1, k)
            if mid + 1 < m and mat[mid + 1][max_idx] > max_val:
                return find(mid + 1, j, k)
            return [mid, max_idx]
        return find(0, m - 1, n // 2)