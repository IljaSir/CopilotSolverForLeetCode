class Solution:
    def tallestBillboard(self, rods: List[int]) -> int:
        
        dp = [0] * 5001
        for rod in rods:
            for i in range(5000, rod-1, -1):
                dp[i] = max(dp[i], dp[i-rod] + rod)
            for i in range(rod, 5000):
                dp[i] = max(dp[i], dp[i+rod] + rod)
        return dp[0] // 2