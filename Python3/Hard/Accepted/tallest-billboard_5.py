class Solution:
    def tallestBillboard(self, rods: List[int]) -> int:
        
        dp = {0:0}
        for rod in rods:
            for d, h in dp.copy().items():
                dp[d + rod] = max(dp.get(d + rod, 0), h)
                dp[abs(d - rod)] = max(dp.get(abs(d - rod), 0), h + min(d, rod))
        return dp[0]