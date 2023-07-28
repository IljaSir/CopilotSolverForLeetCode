class Solution:
    def matrixBlockSum(self, mat: List[List[int]], k: int) -> List[List[int]]:
        
        # Solution 1: Brute force
        # Time: O(M*N*K^2)
        # Space: O(M*N)
        # M = len(mat)
        # N = len(mat[0])
        # ans = [[0] * N for _ in range(M)]
        # for i in range(M):
        #     for j in range(N):
        #         for r in range(max(0, i-k), min(M, i+k+1)):
        #             for c in range(max(0, j-k), min(N, j+k+1)):
        #                 ans[i][j] += mat[r][c]
        # return ans

        # Solution 2: Prefix sum
        # Time: O(M*N)
        # Space: O(M*N)
        # M = len(mat)
        # N = len(mat[0])
        # ans = [[0] * N for _ in range(M)]
        # prefix_sum = [[0] * (N+1) for _ in range(M+1)]
        # for i in range(M):
        #     for j in range(N):
        #         prefix_sum[i+1][j+1] = prefix_sum[i][j+1] + prefix_sum[i+1][j] - prefix_sum[i][j] + mat[i][j]
        # for i in range(M):
        #     for j in range(N):
        #         r1 = max(0, i-k)
        #         c1 = max(0, j-k)
        #         r2 = min(M, i+k+1)
        #         c2 = min(N, j+k+1)
        #         ans[i][j] = prefix_sum[r2][c2] - prefix_sum[r1][c2] - prefix_sum[r2][c1] + prefix_sum[r1][c1]
        # return ans

        # Solution 3: Prefix sum, optimized
        # Time: O(M*N)
        # Space: O(M*N)
        M = len(mat)
        N = len(mat[0])
        ans = [[0] * N for _ in range(M)]
        prefix_sum = [[0] * (N+1) for _ in range(M+1)]
        for i in range(M):
            for j in range(N):
                prefix_sum[i+1][j+1]