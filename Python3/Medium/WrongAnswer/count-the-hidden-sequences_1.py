class Solution:
    def numberOfArrays(self, differences: List[int], lower: int, upper: int) -> int:
        
        n = len(differences)
        dp = [0] * (n + 1)
        dp[0] = 1
        for i in range(n):
            if differences[i] == 0:
                dp[i + 1] = dp[i]
            elif differences[i] > 0:
                dp[i + 1] = dp[i] * (upper - lower + 1)
            else:
                dp[i + 1] = dp[i] * (lower - upper + 1)
        return dp[-1] % (10 ** 9 + 7)