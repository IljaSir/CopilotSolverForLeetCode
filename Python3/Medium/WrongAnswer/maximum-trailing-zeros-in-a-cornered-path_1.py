class Solution:
    def maxTrailingZeros(self, grid: List[List[int]]) -> int:
        
        # calculate the number of 5 and 2 in the grid
        # the number of trailing zeros is min of the number of 5 and 2
        # https://leetcode.com/problems/maximum-trailing-zeros-in-a-cornered-path/discuss/1067550/Python-3-Explanation-with-Diagrams
        # https://leetcode.com/problems/maximum-trailing-zeros-in-a-cornered-path/discuss/1067544/Python-3-4-lines-DFS-with-explanation
        def count_5_2(num):
            c5, c2 = 0, 0
            while num % 5 == 0:
                c5 += 1
                num //= 5
            while num % 2 == 0:
                c2 += 1
                num //= 2
            return c5, c2

        m, n = len(grid), len(grid[0])
        dp = [[0, 0] for _ in range(n)]
        for i in range(m):
            for j in range(n):
                c5, c2 = count_5_2(grid[i][j])
                if i == 0 and j == 0:
                    dp[j][0] = c5
                    dp[j][1] = c2
                    continue
                if i == 0:
                    dp[j][0] = dp[j-1][0] + c5
                    dp[j][1] = dp[j-1][1] + c2
                    continue
                if j == 0:
                    dp[j][0] = dp[j][0] + c5
                    dp[j][1] = dp[j][1] + c2
                    continue
                dp[j][0] = min(dp[j-1][0] + c5, dp[j][0] + c5)
                dp[j][1] = min(dp[j-1][1] + c2, dp[j][1] + c2)
        return min(dp[-1][0], dp[-1][1])