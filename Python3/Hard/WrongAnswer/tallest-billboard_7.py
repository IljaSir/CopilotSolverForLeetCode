class Solution:
    def tallestBillboard(self, rods: List[int]) -> int:
        
        dp = {0:0}
        for rod in rods:
            for key in list(dp):
                dp[key+rod] = max(dp.get(key+rod, 0), dp[key])
                dp[abs(key-rod)] = max(dp.get(abs(key-rod), 0), dp[key] + min(key, rod))
        return dp[0]