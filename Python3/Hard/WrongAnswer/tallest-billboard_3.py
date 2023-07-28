class Solution:
    def tallestBillboard(self, rods: List[int]) -> int:
        
        dp = {0:0}
        for r in rods:
            for d in list(dp.keys()):
                dp[d+r] = max(dp.get(d+r, 0), dp[d])
                dp[abs(d-r)] = max(dp.get(abs(d-r), 0), dp[d]+min(d, r))
        return dp[0]