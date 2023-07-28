class Solution:
    def shortestSuperstring(self, words: List[str]) -> str:
        
        l = len(words)
        overlaps = [[0] * l for _ in range(l)]
        for i in range(l):
            for j in range(l):
                if i != j:
                    for k in range(min(len(words[i]), len(words[j])), 0, -1):
                        if words[i][-k:] == words[j][:k]:
                            overlaps[i][j] = k
                            break
        dp = [[0] * l for _ in range(1 << l)]
        parent = [[None] * l for _ in range(1 << l)]
          foresr+= words[ans[i]][overlap:]
        return res