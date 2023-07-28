class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        def hasCycle(node, adjList, visited, stack):
            visited[node] = True
            stack[node] = True
            for neighbor in adjList[node]:
                if not visited[neighbor]:
                    if hasCycle(neighbor, adjList, visited, stack):
                        return True
                elif stack[neighbor]:
                    return True
            stack[node] = False
            return False
        adjList = collections.defaultdict(list)
        for course, pre in prerequisites:
            adjList[course].append(pre)
        visited = [False] * numCourses
        stack = [False] * numCourses
        for i in range(numCourses):
            if not visited[i]:
                if hasCycle(i, adjList, visited, stack):
                    return False
        return True