class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        
        def similar(a, b):
            diff = 0
            for i in range(len(a)):
                if a[i] != b[i]:
                    diff += 1
                if diff > 2:
                    return False
            return True
        def dfs(i):
            for j in range(len(strs)):
                if similar(strs[i], strs[j]) and not visited[j]:
                    visited[j] = 1
                    dfs(j)
        visited = [0]*len(strs)
        res = 0
        for i in range(len(strs)):
            if not visited[i]:
                dfs(i)
                res += 1
        return res