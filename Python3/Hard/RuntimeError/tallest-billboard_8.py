class Solution:
    def tallestBillboard(self, rods: List[int]) -> int:
        
        dp = {0: 0}
        for rod in rods:
            new_dp = {}
            for d in dp:
                new_dp[d + rod] = max(new_dp.get(d + rod, 0), dp[d])
                new_dp[abs(d - rod)] = max(new_dp.get(abs(d - rod), 0), dp[d] + min(d, rod))
            dp = new_dp
        return dp[0]