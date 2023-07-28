class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        
        def isSimilar(a, b):
            diff = 0
            for i in range(len(a)):
                if a[i] != b[i]:
                    diff += 1
                    if diff > 2:
                        return False
            return True
        def dfs(i):
            for j in range(len(strs)):
                if isSimilar(strs[i], strs[j]) and not visited[j]:
                    visited[j] = True
                    dfs(j)
        visited = [False] * len(strs)
        ans = 0
        for i in range(len(strs)):
            if not visited[i]:
                ans += 1
                dfs(i)
        return ans