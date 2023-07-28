class Solution:
    def tallestBillboard(self, rods: List[int]) -> int:
        
        dp = {0:0}
        for rod in rods:
            for diff in list(dp.keys()):
                dp[diff+rod] = max(dp.get(diff+rod, 0), dp[diff])
                dp[abs(diff-rod)] = max(dp.get(abs(diff-rod), 0), dp[diff]+min(diff, rod))
        return dp[0]