class Solution:
    def minimumHammingDistance(self, source: List[int], target: List[int], allowedSwaps: List[List[int]]) -> int:
        
        # 1. build graph
        # 2. find connected components
        # 3. for each connected component, find the number of elements that are different
        # 4. sum up the number of elements that are different for all connected components
        n = len(source)
        graph = collections.defaultdict(list)
        for i, j in allowedSwaps:
            graph[i].append(j)
            graph[j].append(i)
        visited = set()
        def dfs(node):
            visited.add(node)
            for nei in graph[node]:
                if nei not in visited:
                    dfs(nei)
        res = 0
        for i in range(n):
            if i not in visited:
                cnt = collections.Counter()
                dfs(i)
                for j in visited:
                    cnt[source[j]] += 1
                    cnt[target[j]] -= 1
                res += sum(abs(v) for v in cnt.values()) // 2
        return res