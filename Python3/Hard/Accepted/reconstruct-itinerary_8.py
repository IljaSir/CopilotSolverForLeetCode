class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        
        # construct the graph
        graph = collections.defaultdict(list)
        for u, v in tickets:
            graph[u].append(v)
        for u in graph:
            graph[u].sort(reverse=True)
        
        # backtracking
        route = []
        def dfs(u):
            while graph[u]:
                dfs(graph[u].pop())
            route.append(u)
        
        dfs('JFK')
        return route[::-1]