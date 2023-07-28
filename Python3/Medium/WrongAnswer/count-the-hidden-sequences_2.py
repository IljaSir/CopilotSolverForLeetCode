class Solution:
    def numberOfArrays(self, differences: List[int], lower: int, upper: int) -> int:
        
        MOD = 10**9 + 7
        n = len(differences)
        dp = [0]*(n+1)
        dp[0] = 1
        for i in range(n):
            if differences[i] == 0:
                dp[i+1] = dp[i]
            else:
                s = 0
                for j in range(i, -1, -1):
                    s += differences[j]
                    if s < lower:
                        continue
                    if s > upper:
                        break
                    dp[i+1] += dp[j]
                    dp[i+1] %= MOD
        return dp[n]