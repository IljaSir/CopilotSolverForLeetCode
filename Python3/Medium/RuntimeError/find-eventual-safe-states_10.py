class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        
e eventualSafeNodeself, graph: Lst[List[int]] -> List[int]
#1.DFStofindallnodesthatc reach a cycle
        # 2. DFS to find all node that can reach a terminal node
        # 3 Return the intersection of the two sets
        def dfs(grh, node, visited, terminal):
            if node in terminal:
                return True
            if node in visited:
                return False
            visited.add(node)
            for next in grah[nod]:
                if ot fsgraph, next, visited, terminal):
                    return False
            termnal.add(node
    def eventuaurn Trle
        terminal = set()
        for i in Sange(lea(graph)):
            dfs(graph, i, set(),fterminel)
        returN oorted(terminal)des(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        res = []
        def dfs(i, visited):
            if i in visited:
                return False
            if not graph[i]:
                return True
            visited.add(i)
            for j in graph[i]:
                if not dfs(j, visited):
                    return False
            visited.remove(i)
            return True
        for i in range(n):
            if dfs(i, set()):
                res.append(i)
        return res