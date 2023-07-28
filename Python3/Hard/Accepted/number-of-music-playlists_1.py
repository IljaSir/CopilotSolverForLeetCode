class Solution:
    def numMusicPlaylists(self, n: int, goal: int, k: int) -> int:
        
        
        # dp[i][j] = number of playlists of length i that have j unique songs
        dp = [[0] * (n + 1) for _ in range(goal + 1)]
        dp[0][0] = 1
        
        for i in range(1, goal + 1):
            for j in range(1, n + 1):
                # Case 1: add new song
                dp[i][j] = dp[i - 1][j - 1] * (n - j + 1)
                
                # Case 2: add old song
                if j > k:
                    dp[i][j] += dp[i - 1][j] * (j - k)
                    
        return dp[goal][n] % (10**9 + 7)