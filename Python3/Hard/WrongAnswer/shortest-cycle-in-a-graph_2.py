class Solution:
    def findShortestCycle(self, n: int, edges: List[List[int]]) -> int:
        
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        res = float('inf')
        for u in range(n):
            q = collections.deque([(u, -1, 0)])
            seen = set()
            while q:
                cur, pre, length = q.popleft()
                if cur in seen:
                    if cur == u and length > 2:
                        res = min(res, length)
                    continue
                seen.add(cur)
                for nei in graph[cur]:
                    if nei != pre:
                        q.append((nei, cur, length+1))
        return res if res != float('inf') else -1