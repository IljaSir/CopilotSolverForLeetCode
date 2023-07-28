class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        
        from collections import defaultdict
        def dfs(s):
            while graph[s]:
                dfs(graph[s].pop())
            res.append(s)
        graph = defaultdict(list)
        res = []
        for f, t in sorted(tickets)[::-1]:
            graph[f].append(t)
        dfs('JFK')
        return res[::-1]