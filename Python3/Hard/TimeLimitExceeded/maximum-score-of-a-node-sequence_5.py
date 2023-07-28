class Solution:
    def maximumScore(self, scores: List[int], edges: List[List[int]]) -> int:
        
        # 1. build a graph
        # 2. find all the paths of length 4
        # 3. return the max of the sum of scores of the nodes in the path
        from collections import defaultdict
        graph = defaultdict(list)
        for a, b in edges:
            graph[a].append(b)
            graph[b].append(a)
        def dfs(node, path, visited):
            if len(path) == 4:
                return sum(scores[i] for i in path)
            visited.add(node)
            res = -1
            for nei in graph[node]:
                if nei not in visited:
                    res = max(res, dfs(nei, path + [nei], visited))
            visited.remove(node)
            return res
        res = -1
        for node in range(len(scores)):
            res = max(res, dfs(node, [node], set()))
        return res