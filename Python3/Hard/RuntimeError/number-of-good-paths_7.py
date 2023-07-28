class Solution:
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
        
        if not edges:
            return 1
        edges = {x:[] for x in range(len(vals))}
        for x, y in edges:
            edges[x].append(y)
            edges[y].append(x)
        self.res = 0
        def dfs(node, path):
            if vals[node] < max(path):
                return
            if len(path) > 1 and vals[node] == max(path):
                self.res += 1
            for x in edges[node]:
                dfs(x, path + [vals[x]])
        dfs(0, [vals[0]])
        return self.res