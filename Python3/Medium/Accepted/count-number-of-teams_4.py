class Solution:
    def numTeams(self, rating: List[int]) -> int:
        
        # brute force
        # n = len(rating)
        # res = 0
        # for i in range(n):
        #     for j in range(i+1, n):
        #         for k in range(j+1, n):
        #             if rating[i] < rating[j] < rating[k] or rating[i] > rating[j] > rating[k]:
        #                 res += 1
        # return res
        
        # dp
        n = len(rating)
        dp = [[0, 0] for _ in range(n)]
        res = 0
        for i in range(n):
            for j in range(i):
                if rating[j] < rating[i]:
                    dp[i][0] += 1
                    res += dp[j][0]
                elif rating[j] > rating[i]:
                    dp[i][1] += 1
                    res += dp[j][1]
        return res