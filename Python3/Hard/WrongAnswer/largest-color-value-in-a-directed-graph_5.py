class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
        seen = [0] * len(colors)
        stack = []
        def dfs(node):
            if seen[node] == 1:
                return 0
            if seen[node] == 2:
                return 1
            seen[node] = 1
            stack.append(node)
            for nei in graph[node]:
                if not dfs(nei):
                    return 0
            seen[node] = 2
            stack.pop()
            return 1
        for i in range(len(colors)):
            if not dfs(i):
                return -1
        res = 0
        color_count = collections.Counter()
        for node in stack:
            color_count[colors[node]] += 1
            res = max(res, color_count[colors[node]])
        return res