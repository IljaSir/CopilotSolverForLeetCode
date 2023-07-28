class Solution:
    def maximumRows(self, matrix: List[List[int]], numSelect: int) -> int:
        
        m, n = len(matrix), len(matrix[0])
        def countOnes(mask):
            count = 0
            while mask:
                count += 1
                mask &= mask - 1
            return count
        def countRows(mask):
            count = 0
            for row in range(m):
                for col in range(n):
                    if matrix[row][col] == 1 and (1 << col) & mask == 0:
                        break
                else:
                    count += 1
            return count
        ans = 0
        for mask in range(1 << n):
            if countOnes(mask) == numSelect:
                ans = max(ans, countRows(mask))
        return ans