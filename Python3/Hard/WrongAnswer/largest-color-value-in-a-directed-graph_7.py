class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
        seen = [0] * len(colors)
        res = [0] * len(colors)
        def dfs(i):
            if seen[i] == 1:
                return True
            if seen[i] == 2:
                return False
            seen[i] = 1
            for j in graph[i]:
                if dfs(j):
                    return True
                res[i] = max(res[i], res[j])
            seen[i] = 2
            res[i] += 1
            return False
        for i in range(len(colors)):
            if dfs(i):
                return -1
        return max(res)