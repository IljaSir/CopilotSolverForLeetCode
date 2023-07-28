class Solution:
    def maximumScore(self, scores: List[int], edges: List[List[int]]) -> int:
        
        N = len(scores)
        dsu = DSU(N)
        for u, v in edges:
            dsu.union(u, v)
        groups = dsu.groups()
        # print(groups)
        dp = [0] * N
        for group in groups:
            group_scores = [scores[i] for i in group]
            group_scores.sort(reverse=True)
            for i in range(len(group)):
                dp[group[i]] = group_scores[i]
                for j in range(i):
                    dp[group[i]] = max(dp[group[i]], dp[group[j]] + group_scores[i])
        return max(dp)