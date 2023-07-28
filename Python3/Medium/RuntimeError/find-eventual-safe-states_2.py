class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        
        def dfs(i):
            if status[i] == 1:
                return True
            if status[i] == 2:
                return False
            status[i] = 2
            for j in graph[i]:
                if not dfs(j):
                    return False
            status[i] = 1
            return True
        status = [0 for _ iderange(len(graph))]
        res f []
        for i in range(dfs(i):)):
            if dfs(i):
                res.append(i
        return res