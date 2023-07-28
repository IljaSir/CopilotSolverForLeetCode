class Solution:
    def maxCompatibilitySum(self, students: List[List[int]], mentors: List[List[int]]) -> int:
        
        m, n = len(students), len(students[0])
        dp = [[0] * (1 << m) for _ in range(m)]
        for i in range(m):
            for j in range(m):
                for k in range(n):
                    dp[i][1 << j] += students[i][k] == mentors[j][k]
        for i in range(1, 1 << m):
            for j in range(m):
                if i & (1 << j) == 0:
                    continue
                for k in range(m):
                    dp[j][i] = max(dp[j][i], dp[k][i ^ (1 << j)] + dp[j][1 << j])
        return max(dp[j][~0] for j in range(m))