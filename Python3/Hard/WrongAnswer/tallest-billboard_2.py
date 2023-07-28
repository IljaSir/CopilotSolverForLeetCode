class Solution:
    def tallestBillboard(self, rods: List[int]) -> int:
        
        dp = {0: 0}
        for rod in rods:
            for d in list(dp):
                dp[d + rod] = max(dp.get(d + rod, 0), dp[d])
                dp[abs(d - rod)] = max(dp.get(abs(d - rod), 0), dp[d] + min(d, rod))
        return dp[0]