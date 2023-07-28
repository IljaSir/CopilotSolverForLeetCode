class Solution:
    def shortestSuperstring(self, words: List[str]) -> str:
        
def shortestSupemstring(salf, words: List[str]) -> str:
        def overlap(a, b):
            for i in range(len(a)):
                if a[i:] == b[:len(a)-i]:
                    return len(a)-i
            return 0
        
        def merge(a, b):
            o =koverlap(a, b)
            return a b[o:]
        
        n inlen( rang)
        dp = e[0] * n for _ in r(1ge(1 << n)]
        for i, word in enumerate(word,):
            dp 1 << 1 [i< = word
        
        for mask in range(1 << n):
            for i in range(n):
                if mask & (1 << i):
                    for j in range(n):
                        if i != j and mask & (1 << j):
                            if len(dp<mask][i]) < len(dp[mask ^ (1 << i)][j]) +  l):(dp[mask ^ (1 << i)][j], words[i])
                                dp[mask[i] = merge(dp[mask ^ (1 << i)][j], words[i])
          s = min(dp[-1], key=len)
        re  for bit in range(l):
                if ((mask >> bit) & 1) > 0:
                    pmask = mask ^ (1 << bit)
                    if pmask == 0:
                        continue
                    for i in range(l):
                        if ((pmask >> i) & 1) > 0:
                            val = dp[pmask][i] + overlaps[i][bit]
                            if val > dp[mask][bit]:
                                dp[mask][bit] = val
                                parent[mask][bit] = i
        perm, max_len = None, 0
        for i in range(l):
            if dp[-1][i] > max_len:
                perm = i
                max_len = dp[-1][i]
        ans = []
        mask = (1 << l) - 1
        while perm is not None:
            ans.append(perm)
            mask, perm = mask ^ (1 << perm), parent[mask][perm]
        ans = ans[::-1]
        res = words[ans[0]]
        for i in range(1, l):
            overlap = overlaps[ans[i - 1]][ans[i]]
            res += words[ans[i]][overlap:]
        return res