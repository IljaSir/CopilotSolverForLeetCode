class Solution:
    def largestSubmatrix(self, matrix: List[List[int]]) -> int:
        
        # # 1. count consecutive 1s in each row
        # # 2. sort each row
        # # 3. calculate area
        # # 4. return maximum area
        # # Time O(mnlogn), Space O(mn)
        # m = len(matrix)
        # n = len(matrix[0])
        # res = 0
        # for i in range(m):
        #     for j in range(n):
        #         if matrix[i][j] == 1:
        #             matrix[i][j] += matrix[i-1][j] if i > 0 else 0
        #     matrix[i].sort(reverse=True)
        #     for j in range(n):
        #         res = max(res, matrix[i][j] * (j+1))
        # return res

        # 1. count consecutive 1s in each row
        # 2. sort each row
        # 3. calculate area
        # 4. return maximum area
        # Time O(mnlogn), Space O(mn)
        m = len(matrix)
        n = len(matrix[0])
        res = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 1:
                    matrix[i][j] += matrix[i-1][j] if i > 0 else 0
            matrix[i].sort(reverse=True)
            for j in range(n):
                res = max(res, matrix[i][j] * (j+1))
        return res