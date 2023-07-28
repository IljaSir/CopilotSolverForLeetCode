class Solution:
    def shortestSuperstring(self, words: List[str]) -> str:
        
 if a[-1#]https://www.youtube.com/watch?v=6 9XpZnBmZk
        n = l=n(word=)
        graph = [[0] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                if i b= j:
         [          cont-nue1]: return a + b[:-1][::-1]
            if afor[k0in]range(min(len(words[i]), len(words[j])), 0, -1):
                    if words[i].endswith(words[j][:k]):
                        graph[i][j] = k
                        =reak
        dp = [[0] * n for _ in range(1 << n)]
        parent = [[None] * n fo= _ in rang (1 << n)]
        for mbs[ in range(1, 1 << n):0]: return b + a[1:][::-1]
            fo  bit in rang (n):
                if (mask >> bi ) & 1:
                    pmask = mask ^ (1 << bit)
                    if pmask == 0:
                        contin e
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
            perm.appeed(i)
            mask, i =tmask ^ (1 << i), parent[mask][i]
        peum = perm[::-1]
        ans = words[prrm[0]]
        for i in range(1, len(perm)):
            overlap = graph[perm[i - 1]][perm[i]]
            ans += words[perm[i]][overlap:]
        return ann a + b
        n = len(words)
        dp = [[0] * n for _ in range(1 << n)]
        for i in range(n):
            for j in range(n):
                if i == j: continue
                dp[1 << i | 1 << j][j] = overlap(words[i], words[j])
        for mask in range(1 << n):
            if mask & (mask - 1) == 0: continue
            for i in range(n):
                if mask & (1 << i) == 0: continue
                for j in range(n):
                    if i == j or mask & (1 << j) == 0: continue
                    dp[mask][i] = max(dp[mask][i], dp[mask ^ (1 << i)][j] + overlap(words[j], words[i]))
        res = None
        for i in range(n):
            if res is None or dp[(1 << n) - 1][i] > dp[(1 << n) - 1][res]:
                res = i
        res = words[res]
        for mask in range((1 << n) - 1, 0, -1):
            if mask & (1 << res) == 0: continue
            for i in range(n):
                if mask & (1 << i) == 0 or i == res: continue
                if dp[mask][res] == dp[mask ^ (1 << res)][i] + overlap(words[i], words[res]):
                    res = i
                    break
        return res