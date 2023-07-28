class Solution:
    def shortestSuperstring(self, words: List[str]) -> str:
        
        n = len(words)
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
                            value = dp[pmask][i] + self.overlap(words[i], words[bit])
                            if value > dp[mask][bit]:
                                dp[mask][bit] = value
                                parent[mask][bit] = i
        perm = None
        perm_mask = (1 << n) - 1
        perm_value = 0
        for i in range(n):
            if dp[perm_mask][i] > perm_value:
                perm = i
                perm_value = dp[perm_mask][i]
        ans = []
        while perm is not None:
            ans.append(words[perm])
            perm_mask, perm = perm_mask ^ (1 << perm), parent[perm_mask][perm]
        return "".join(ans[::-1])