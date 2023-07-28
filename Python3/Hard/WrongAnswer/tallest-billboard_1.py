class Solution:
    def tallestBillboard(self, rods: List[int]) -> int:
        
        dp = {0: 0}
        for x in rods:
            for d in list(dp):
                dp[d+x] = max(dp.get(d+x, 0), dp[d])
                dp[abs(d-x)] = max(dp.get(abs(d-x), 0), dp[d] + min(d, x))
        return dp[0]