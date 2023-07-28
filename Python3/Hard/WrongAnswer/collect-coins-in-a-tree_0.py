class Solution:
    def collectTheCoins(self, coins: List[int], edges: List[List[int]]) -> int:
        
        
        # Create a graph
        graph = [[] for _ in range(len(coins))]
        for edge in edges:
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])
        
        # DFS
        def dfs(node, parent):
            # Base case
            if len(graph[node]) == 1 and parent != -1:
                return coins[node]
            
            # Recursive case
            total = coins[node]
            for child in graph[node]:
                if child != parent:
                    total += dfs(child, node)
            return total
        
        # DFS
        def dfs2(node, parent):
            # Base case
            if len(graph[node]) == 1 and parent != -1:
                return coins[node]
            
            # Recursive case
            total = coins[node]
            for child in graph[node]:
                if child != parent:
                    total += dfs2(child, node)
            return total
        
        # Find the root
        root = 0
        for i in range(len(graph)):
            if len(graph[i]) == 1:
                root = i
                break
        
        # DFS to find the total number of coins in the tree
        total = dfs(root, -1)
        
        # DFS to find the number of coins in each subtree
        coins_in_subtree = [0] * len(coins)
        for i in range(len(coins)):
            coins_in_subtree[i] = dfs2(i, -1)
        
        # Find the answer
        ans = 0
        for i in range(len(coins)):
            if coins[i] == 1:
                ans += 1
                if i != root:
                    ans += 2 * (coins_in_subtree[i] - 1)
                    ans += (total - coins_in_subtree[i] - 1)
        return ans