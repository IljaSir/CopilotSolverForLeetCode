class Solution:
    def knightDialer(self, n: int) -> int:
        
        MOD = 10**9 + 7
        moves = [(-2, -1), (-2, 1), (-1, -2), (-1, 2), (1, -2), (1, 2), (2, -1), (2, 1)]
        dp = [1]*10
        for _ in range(n-1):
            dp2 = [0]*10
            for i, x in enumerate(dp):
                for dx, dy in moves:
                    j = i + dx + dy*3
                    if 0 <= j < 10 and abs(i%3 - j%3) == 1:
                        dp2[j] += x
                        dp2[j] %= MOD
            dp = dp2
        return sum(dp) % MOD