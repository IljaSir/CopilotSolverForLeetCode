class Solution:
    def shortestSuperstring(self, words: List[str]) -> str:
        
        # https://www.youtube.com/watch?v=6r9XpZnBmZk
        n = len(words)
        graph = [[0] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                if i == j:
                    continue
                for k in range(min(len(words[i]), len(words[j])), 0, -1):
                    if words[i].endswith(words[j][:k]):
                        graph[i][j] = k
                        break
        dp = [[0] * n for _ in range(1 << n)]
        parent = [[None] * n for _ in range(1 << n)]
        for mask in range(1, 1 << n):
            for bit in range(n):
                if (mask >> bit) & 1:
                    pmask = mask ^ (1 << bit)
                    if pmask == 0:
                        continue
                    for i in range(n):
                        if (pmask >> i) & 1:
                            val = dp[pmask][i] + graph[i][bit]
                            if val > dp[mask][bit]:
                                dp[mask][bit] = val
                                parent[mask][bit] = i
        perm = []
        mask = (1 << n) - 1
        i = max(range(n), key=dp[-1].__getitem__)
        while i is not None:
            perm.append(i)
            mask, i = mask ^ (1 << i), parent[mask][i]
        perm = perm[::-1]
        ans = words[perm[0]]
        for i in range(1, len(perm)):
            overlap = graph[perm[i - 1]][perm[i]]
            ans += words[perm[i]][overlap:]
        return ans