class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        
        
        # if source == destination:
        #     return True
        # graph = collections.defaultdict(set)
        # for u, v in edges:
        #     graph[u].add(v)
        #     graph[v].add(u)
        # visited = set()
        # stack = [source]
        # while stack:
        #     node = stack.pop()
        #     if node == destination:
        #         return True
        #     visited.add(node)
        #     for nei in graph[node]:
        #         if nei not in visited:
        #             stack.append(nei)
        # return False

        # if source == destination:
        #     return True
        # graph = collections.defaultdict(set)
        # for u, v in edges:
        #     graph[u].add(v)
        #     graph[v].add(u)
        # visited = set()
        # queue = collections.deque([source])
        # while queue:
        #     node = queue.popleft()
        #     if node == destination:
        #         return True
        #     visited.add(node)
        #     for nei in graph[node]:
        #         if nei not in visited:
        #             queue.append(nei)
        # return False

        if source == destination:
            return True
        graph = collections.defaultdict(set)
        for u, v in edges:
            graph[u].add(v)
            graph[v].add(u)
        visited = set()
        def dfs(node):
            if node == destination:
                return True
            visited.add(node)
            for nei in graph[node]:
                if nei not in visited:
                    if dfs(nei):
                        return True
            return False
        return dfs(source)