class Solution:
    def shortestSuperstring(self, words: List[str]) -> str:
        
        n = len(words)
        overlap = [[0] * n for _ in range(n)]
        for i, x in enumerate(words):
            for j, y in enumerate(words):
                if i != j:
                    for k in range(min(len(x), len(y)), 0, -1):
                        if x.endswith(y[:k]):
                            overlap[i][j] = k
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
                            val = dp[pmask][i] + overlap[i][bit]
                            if val > dp[mask][bit]:
                                dp[mask][bit] = val
                                parent[mask][bit] = i
        perm = []
        mask = (1 << n) - 1
        i = max(range(n), key = dp[-1].__getitem__)
        while i is not None:
            perm.append(i)
            mask, i = mask ^ (1 << i), parent[mask][i]
        perm = perm[::-1]
        ans = [None] * n
        for i, j in zip(perm, perm[1:] + [perm[0]]):
            overlap_ij = overlap[i][j]
            ans[i] = words[i] + words[j][overlap_ij:]
        return "".join(ans)