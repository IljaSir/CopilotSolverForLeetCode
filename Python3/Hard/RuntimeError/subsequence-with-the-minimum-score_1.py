class Solution:
    def minimumScore(self, s: str, t: str) -> int:
        
        # 1st solution
        # Time: O(n)  Space: O(n)
        # n = len(s)
        # m = len(t)
        # dp = [float('inf')] * (m+1)
        # for i in range(n):
        #     dp2 = dp[:]
        #     for j in range(m):
        #         if s[i] == t[j]:
        #             dp2[j+1] = min(dp2[j+1], dp[j], 1 + dp2[j])
        #     dp = dp2
        # return dp[m]

        # 2nd solution
        # Time: O(n)  Space: O(n)
        # n = len(s)
        # m = len(t)
        # dp = [float('inf')] * (m+1)
        # for i in range(n):
        #     dp2 = dp[:]
        #     for j in range(m):
        #         if s[i] == t[j]:
        #             dp2[j+1] = min(dp2[j+1], dp[j], 1 + dp2[j])
        #     dp = dp2
        # return dp[m]

        # 3rd solution
        # Time: O(n)  Space: O(n)
        # n = len(s)
        # m = len(t)
        # dp = [float('inf')] * (m+1)
        # for i in range(n):
        #     dp2 = dp[:]
        #     for j in range(m):
        #         if s[i] == t[j]:
        #             dp2[j+1] = min(dp2[j+1], dp[j], 1 + dp2[j])
        #     dp = dp2
        # return dp[m]

        # 4th solution
        # Time: O(n)  Space: O(n)
        # n = len(s)
        # m = len(t)
        # dp = [float('inf')] * (m+1)
        # for i in range(n):
        #     dp2 = dp[:]
        #     for j in range(m):
        #         if s[i] == t[j]:
        #             dp2[j+1] = min(dp2[j+1], dp[j], 1 + dp2[j])
        #     dp = dp2