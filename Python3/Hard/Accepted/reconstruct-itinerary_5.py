class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        
        from collections import defaultdict
        graph = defaultdict(list)
        for u, v in tickets:
            graph[u].append(v)
        for key in graph:
            graph[key].sort()
        res = []
        def dfs(u):
            while graph[u]:
                dfs(graph[u].pop(0))
            res.append(u)
        dfs('JFK')
        return res[::-1]