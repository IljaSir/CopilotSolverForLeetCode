class Solution:
    def tallestBillboard(self, rods: List[int]) -> int:
        
        # dp[i][j] = max(dp[i-1][j], dp[i-1][j-rods[i]]+rods[i])
        dp = {0: 0}
        for rod in rods:
            dp2 = dp.copy()
            for d, h in dp.items():
                dp2[d+rod] = max(dp2.get(d+rod, 0), h+rod)
                dp2[abs(d-rod)] = max(dp2.get(abs(d-rod), 0), h)
            dp = dp2
        return dp[0] // 2