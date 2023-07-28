class Solution:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        
        # 1. check if there is a cycle
        # 2. check if there is a root
        # 3. check if there is only one root
        # 4. check if there is a node with no parent
        # 5. check if there is a node with more than one parent
        # 6. check if there is a node with no child
        def dfs(node, visited):
            if node in visited:
                return False
            visited.add(node)
            if leftChild[node] != -1:
                if not dfs(leftChild[node], visited):
                    return False
            if rightChild[node] != -1:
                if not dfs(rightChild[node], visited):
                    return False
            return True

        visited = set()
        root = 0
        for i in range(n):
            if leftChild[i] != -1 or rightChild[i] != -1:
                root = i
                break
        if not dfs(root, visited):
            return False
        if len(visited) != n:
            return False
        return True