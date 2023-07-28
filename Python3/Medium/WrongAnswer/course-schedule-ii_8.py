class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        # create a graph
        graph = {i:[] for i in range(numCourses)}
        for i in prerequisites:
            graph[i[0]].append(i[1])
        #print(graph)
        # check for cycle
        def dfs(node, visited, stack):
            visited[node] = 1
            for i in graph[node]:
                if visited[i] == 0:
                    if dfs(i, visited, stack):
                        return True
                elif visited[i] == 1:
                    return True
            visited[node] = 2
            stack.append(node)
            return False
        visited = [0 for i in range(numCourses)]
        stack = []
        for i in range(numCourses):
            if visited[i] == 0:
                if dfs(i, visited, stack):
                    return []
        return stack[::-1]