class Solution:
    def knightDialer(self, n: int) -> int:
        
        MOD = 10**9 + 7
        moves = [[4,6], [6,8], [7,9], [4,8], [0,3,9], [], [0,1,7], [2,6], [1,3], [2,4]]
        dp = [1] * 10
        for _ in range(n - 1):
            dp2 = [0] * 10
            for x in range(10):
                for y in moves[x]:
                    dp2[y] += dp[x]
                    dp2[y] %= MOD
            dp = dp2
        return sum(dp) % MOD