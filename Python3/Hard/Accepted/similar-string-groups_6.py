class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        
        def similar(s1, s2):
            if s1 == s2:
                return True
            if len(s1) != len(s2):
                return False
            diff = 0
            for i in range(len(s1)):
                if s1[i] != s2[i]:
                    diff += 1
            return diff == 2
        
        def dfs(i):
            for j in range(len(strs)):
                if similar(strs[i], strs[j]) and not visited[j]:
                    visited[j] = True
                    dfs(j)
        
        visited = [False] * len(strs)
        ans = 0
        for i in range(len(strs)):
            if not visited[i]:
                ans += 1
                dfs(i)
        return ans