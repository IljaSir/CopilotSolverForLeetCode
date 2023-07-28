class Solution:
    def knightDialer(self, n: int) -> int:
        
        MOD = 10**9 + 7
        moves = [[4,6],[6,8],[7,9],[4,8],[0,3,9],[],[0,1,7],[2,6],[1,3],[2,4]]
        dp = [1]*10
        for i in range(n-1):
            dp = [sum(dp[j] for j in moves[i])%MOD for i in range(10)]
        return sum(dp)%MOD