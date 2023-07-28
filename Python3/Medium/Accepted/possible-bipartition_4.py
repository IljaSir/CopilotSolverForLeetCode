class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        
        graph = collections.defaultdict(list)
        for u, v in dislikes:
            graph[u].append(v)
            graph[v].append(u)
        colors = [0] * (n + 1)
        for i in range(1, n + 1):
            if colors[i] == 0:
                colors[i] = 1
                queue = collections.deque([i])
                while queue:
                    node = queue.popleft()
                    for nei in graph[node]:
                        if colors[nei] == 0:
                            colors[nei] = -colors[node]
                            queue.append(nei)
                        elif colors[nei] == colors[node]:
                            return False
        return True