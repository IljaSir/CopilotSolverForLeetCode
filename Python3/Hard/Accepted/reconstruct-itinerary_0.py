class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        
        graph = collections.defaultdict(list)
        for a, b in sorted(tickets)[::-1]:
            graph[a] += b,
        route = []
        def dfs(a):
            while graph[a]:
                dfs(graph[a].pop())
            route.append(a)
        dfs('JFK')
        return route[::-1]