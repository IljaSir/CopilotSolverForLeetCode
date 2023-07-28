class Solution:
    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:
        
        # print(n, leftChild, rightChild)
        in_degree = [0] * n
        for i in range(n):
            if leftChild[i] != -1:
                in_degree[leftChild[i]] += 1
            if rightChild[i] != -1:
                in_degree[rightChild[i]] += 1
        # print(in_degree)
        if in_degree.count(0) != 1:
            return False
        seen = set()
        def dfs(node):
            if node in seen:
                return False
            seen.add(node)
            if leftChild[node] != -1:
                if not dfs(leftChild[node]):
                    return False
            if rightChild[node] != -1:
                if not dfs(rightChild[node]):
                    return False
            return True
        return dfs(in_degree.index(0)) and len(seen) == n