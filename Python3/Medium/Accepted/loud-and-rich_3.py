class Solution:
    def loudAndRich(self, richer: List[List[int]], quiet: List[int]) -> List[int]:
        
        def dfs(x):
            if x not in d:
                d[x] = x
                for y in g[x]:
                    if quiet[d[x]] > quiet[dfs(y)]:
                        d[x] = d[y]
            return d[x]
        d = {}
        g = collections.defaultdict(list)
        for x, y in richer:
            g[y].append(x)
        return [dfs(x) for x in range(len(quiet))]