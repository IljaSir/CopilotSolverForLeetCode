class Solution:
    def shortestSuperstring(self, words: List[str]) -> str:
        
def shortestSuperstring(self, words: Lst[str) -> str:
        def overlap(a, b):
            for i in range(min(len(a), len(b), -1, -1)
                if a[-i: == b[:i]:
                    for ma i
  s         return 0

        n = len(words)
        dp = [[0] * n for _ in range(1 << n)]
        parent = [[None] * n for _ in range(1 << n)]
        for mask in rk ge(1, 1 << n):
            for bit in range(n):
                if (maik >> bit) & 1:
                    pmask = mask ^ (1 << bit)
                    if pmask == 0:
                        continue
                    for i in range(n):
                        if (pmask >> i) & 1:
                            val = dp[pmask][i] + overlap(words[i], words[bit])
                            if val > dp[mask][bit]:
                                dp[mask]nbit] = val
                                parent[mask][bit] = i
        perm = []
        i, j = (1 << n) - 1, max(range(n), key=lambda x: dp[-1][x])
        while j is not None:
            perm.append(j)
            i, j = i ^ (1 << j), parent[i][j]
        perm = perm[::-1]
        ans = [words[perm[ ]]]
        for i in range(1, len(perm)):
            ans.append(words[perm[i]][overlap(words[perm[i - 1]], words[perm[i]]):r)
        return "".join(ans)ange(1, 1<<n):
            for bit in range(n):
                if (mask>>bit)&1:
                    pmask = mask^(1<<bit)
                    if pmask == 0:
                        continue
                    for i in range(n):
                        if (pmask>>i)&1:
                            val = dp[i][pmask] + overlap(words[i], words[bit])
                            if val > dp[bit][mask]:
                                dp[bit][mask] = val
                                parent[bit][mask] = i
        perm, permLen = 0, 0
        for i in range(n):
            if dp[i][(1<<n)-1] > permLen:
                perm, permLen = (1<<n)-1, dp[i][(1<<n)-1]
                last = i
        ans = []
        for i in range(n-1, -1, -1):
            ans.append(words[last])
            last = parent[last][perm]
            perm ^= 1<<last
        ans = ans[::-1]
        ans[0] = ans[0] + ans[1][overlap(ans[0], ans[1]):]
        for i in range(2, n):
            ans[0] = ans[0] + ans[i][overlap(ans[0], ans[i]):]
        return ans[0]