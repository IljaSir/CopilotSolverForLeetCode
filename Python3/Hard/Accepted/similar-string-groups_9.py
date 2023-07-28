class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        
        def similar(a, b):
            return sum(1 for i in range(len(a)) if a[i] != b[i]) <= 2
        def dfs(i):
            for j in range(len(strs)):
                if not seen[j] and similar(strs[i], strs[j]):
                    seen[j] = True
                    dfs(j)
        seen = [False] * len(strs)
        ans = 0
        for i in range(len(strs)):
            if not seen[i]:
                ans += 1
                seen[i] = True
                dfs(i)
        return ans