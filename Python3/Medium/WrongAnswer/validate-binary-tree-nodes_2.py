class Solution:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        
        nodes = [0 for _ in range(n)]
        for i in range(n):
            if leftChild[i] != -1:
                nodes[leftChild[i]] += 1
            if rightChild[i] != -1:
                nodes[rightChild[i]] += 1
        root = -1
        for i in range(n):
            if nodes[i] == 0:
                if root != -1:
                    return False
                root = i
        if root == -1:
            return False
        visited = [False for _ in range(n)]
        def dfs(node):
            if node == -1:
                return
            if visited[node]:
                return False
            visited[node] = True
            return dfs(leftChild[node]) and dfs(rightChild[node])
        return dfs(root) and all(visited)