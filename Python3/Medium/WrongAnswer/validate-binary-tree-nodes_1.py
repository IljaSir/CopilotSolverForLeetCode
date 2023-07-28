class Solution:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        
        graph = {i: set() for i in range(n)}
        for i in range(n):
            if leftChild[i] != -1:
                graph[i].add(leftChild[i])
            if rightChild[i] != -1:
                graph[i].add(rightChild[i])
        def dfs(i, visited):
            if i in visited:
                return False
            if not graph[i]:
                return True
            visited.add(i)
            for j in graph[i]:
                if not dfs(j, visited):
                    return False
            return True
        visited = set()
        for i in range(n):
            if not dfs(i, visited):
                return False
        return len(visited) == n