class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        
        def dfs(v):
            while graph[v]:
                dfs(graph[v].pop())
            res.append(v)
        
        graph = collections.defaultdict(list)
        for u, v in sorted(tickets)[::-1]:
            graph[u].append(v)
        res = []
        dfs("JFK")
        return res[::-1]