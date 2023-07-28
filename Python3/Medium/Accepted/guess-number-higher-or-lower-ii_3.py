class Solution:
    def getMoneyAmount(self, n: int) -> int:
        
        dp = [[0] * (n+1) for _ in range(n+1)]
        for length in range(2, n+1):
            for start in range(1, n-length+2):
                global_min = float('inf')
                for piv in range(start+1, start+length-1):
                    local_max = piv + max(dp[start][piv-1], dp[piv+1][start+length-1])
                    global_min = min(global_min, local_max)
                dp[start][start+length-1] = start if length == 2 else global_min
        return dp[1][n]