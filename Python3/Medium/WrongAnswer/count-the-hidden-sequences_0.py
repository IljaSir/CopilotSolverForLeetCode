class Solution:
    def numberOfArrays(self, differences: List[int], lower: int, upper: int) -> int:
        
        MOD = 10**9 + 7
        n = len(differences)
        dp = [0] * (n + 1)
        dp[0] = 1
        for i in range(n):
            if differences[i] < 0:
                lower -= differences[i]
                upper -= differences[i]
            if lower > upper:
                return 0
            if lower <= 0 <= upper:
                dp[i + 1] = (dp[i + 1] + dp[i]) % MOD
            if lower <= 1 <= upper:
                dp[i + 1] = (dp[i + 1] + dp[i]) % MOD
            lower = max(2, lower - differences[i])
            upper = max(2, upper - differences[i])
        return dp[-1]