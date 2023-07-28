class Solution:
    def findRedundantDirectedConnection(self, edges: List[List[int]]) -> List[int]:
        
        n = len(edges)
        # 1. build graph
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
        # 2. find the node with two parents
        parents = [0] * (n + 1)
        for u, v in edges:
            parents[v] += 1
        candidates = []
        for i in range(1, n + 1):
            if parents[i] == 2:
                candidates.append(i)
        # 3. remove the edge with the later appearance
        if candidates:
            for u, v in edges[::-1]:
                if v == candidates[1]:
                    return [u, v]
        # 4. find cycle
        def dfs(u):
            seen.add(u)
            for v in graph[u]:
                if v in seen:
                    return True
                if dfs(v):
                    return True
            seen.remove(u)
            return False
        # 5. remove the edge that forms cycle
        for u, v in edges[::-1]:
            seen = set()
            if parents[v] == 0 and dfs(v):
                return [u, v]
        return []