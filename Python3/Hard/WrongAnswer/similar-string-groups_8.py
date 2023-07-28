class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        
        def similar(a, b):
            if a == b:
                return True
            if len(a) != len(b):
                return False
            if a[0] != b[0] or a[-1] != b[-1]:
                return False
            diff = 0
            for i in range(len(a)):
                if a[i] != b[i]:
                    diff += 1
                if diff > 2:
                    return False
            return True
        def dfs(i):
            for j in range(len(strs)):
                if similar(strs[i], strs[j]) and j not in visited:
                    visited.add(j)
                    dfs(j)
        visited = set()
        ans = 0
        for i in range(len(strs)):
            if i not in visited:
                ans += 1
                dfs(i)
        return ans