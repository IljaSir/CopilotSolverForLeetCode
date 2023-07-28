class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        

        # 1. create a graph
        graph = {}
        for eq in equations:
            if eq[1] == '!':
                continue
            if eq[0] not in graph:
                graph[eq[0]] = []
            if eq[3] not in graph:
                graph[eq[3]] = []
            graph[eq[0]].append(eq[3])
            graph[eq[3]].append(eq[0])
        
        # 2. traverse the graph to find if there is a circle
        visited = {}
        for node in graph:
            if node in visited:
                continue
            stack = [node]
            while stack:
                n = stack.pop()
                if n in visited:
                    continue
                visited[n] = True
                for nei in graph[n]:
                    if nei in visited:
                        return False
                    stack.append(nei)
        return True