class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        
        graph = collections.defaultdict(list)
        for f, t in sorted(tickets)[::-1]:
            graph[f] += t,
        route = []
        def visit(airport):
            while graph[airport]:
                visit(graph[airport].pop())
            route.append(airport)
        visit('JFK')
        return route[::-1]