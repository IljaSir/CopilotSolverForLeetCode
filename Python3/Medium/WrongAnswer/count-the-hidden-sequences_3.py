class Solution:
    def numberOfArrays(self, differences: List[int], lower: int, upper: int) -> int:
        
        MOD = 10**9 + 7
        dp = [1] + [0] * len(differences)
        for i in range(1, len(differences)):
            differences[i] += differences[i - 1]
        for i in range(len(differences)):
            dp[i] = sum(dp[j] for j in range(i) if lower <= differences[i] - differences[j] <= upper) % MOD
        return dp[-1]