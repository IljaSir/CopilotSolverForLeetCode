class Solution:
    def maximumGood(self, statements: List[List[int]]) -> int:
        
        
        # 1. Create a graph
        # 2. Find the strongly connected components
        # 3. For each SCC, find the number of good people
        
        def dfs(node):
            visited[node] = True
            for neighbor in graph[node]:
                if not visited[neighbor]:
                    dfs(neighbor)
            self.stack.append(node)
        
        def dfs2(node):
            visited[node] = True
            self.scc.add(node)
            for neighbor in graph[node]:
                if not visited[neighbor]:
                    dfs2(neighbor)
        
        def find_scc():
            n = len(statements)
            visited = [False] * n
            for i in range(n):
                if not visited[i]:
                    dfs(i)
            
            visited = [False] * n
            while self.stack:
                node = self.stack.pop()
                if not visited[node]:
                    self.scc = set()
                    dfs2(node)
                    self.sccs.append(self.scc)
        
        def find_good():
            n = len(statements)
            for scc in self.sccs:
                good = 0
                for node in scc:
                    if statements[node][node] == 1:
                        good += 1
                if good > self.ans:
                    self.ans = good
        
        self.stack = []
        self.sccs = []
        graph = [[] for _ in range(len(statements))]
        for i in range(len(statements)):
            for j in range(len(statements)):
                if statements[i][j] == 1:
                    graph[i].append(j)
                elif statements[i][j] == 0:
                    graph[j].append(i)
        
        find_scc()
        self.ans = 0
        find_good()
        return self.ans