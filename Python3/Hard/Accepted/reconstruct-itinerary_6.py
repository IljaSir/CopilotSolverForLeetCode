class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        
        def dfs(cur):
            while cur in graph and graph[cur]:
                dfs(graph[cur].pop())
            res.insert(0, cur)
        graph = collections.defaultdict(list)
        for u, v in sorted(tickets)[::-1]:
            graph[u].append(v)
        res = []
        dfs('JFK')
        return res