class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        # matrix: List[List[int]], k: int) -> int:
        # n = len(matrix)
        # if n == 1:
        #     return matrix[0][0]
        # l = matrix[0][0]
        # r = matrix[n-1][n-1]
        # while l < r:
        #     mid = l + (r-l)//2
        #     count = 0
        #     for i in range(n):
        #         for j in range(n):
        #             if matrix[i][j] <= mid:
        #                 count += 1
        #     if count < k:
        #         l = mid + 1
        #     else:
        #         r = mid
        # return l
        # n = len(matrix)
        # if n == 1:
        #     return matrix[0][0]
        # l = matrix[0][0]
        # r = matrix[n-1][n-1]
        # while l < r:
        #     mid = l + (r-l)//2
        #     count = 0
        #     for i in range(n):
        #         for j in range(n):
        #             if matrix[i][j] <= mid:
        #                 count += 1
        #     if count < k:
        #         l = mid + 1
        #     else:
        #         r = mid
        # return l
        n = len(matrix)
        if n == 1:
            return matrix[0][0]
        l = matrix[0][0]
        r = matrix[n-1][n-1]
        while l < r:
            mid = l + (r-l)//2
            count = 0
            for i in range(n):
                for j in range(n):
                    if matrix[i][j] <= mid:
                        count += 1
            if count < k:
                l = mid + 1
            else:
                r = mid
        return l