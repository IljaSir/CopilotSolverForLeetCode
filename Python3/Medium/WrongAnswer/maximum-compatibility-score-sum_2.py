class Solution:
    def maxCompatibilitySum(self, students: List[List[int]], mentors: List[List[int]]) -> int:
        
        m, n = len(students), len(students[0])
        dp = [[0]*m for _ in range(1<<m)]
        for i in range(1, 1<<m):
            for j in range(m):
                if i & (1<<j):
                    for k in range(m):
                        if i & (1<<k):
                            dp[i][j] = max(dp[i][j], dp[i-(1<<j)][k] + sum([students[j][l] == mentors[k][l] for l in range(n)]))
        return max(dp[-1])