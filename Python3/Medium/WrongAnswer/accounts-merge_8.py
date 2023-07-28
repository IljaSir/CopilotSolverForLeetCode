class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        
        # 1. build graph
        # 2. DFS or BFS to find connected components
        # 3. sort email and return
        # 4. O(nlogn) time, O(n) space
        graph = collections.defaultdict(set)
        for account in accounts:
            name = account[0]
            for email in account[1:]:
                graph[account[1]].add(email)
                graph[email].add(account[1])
        
        def dfs(email, visited):
            visited.add(email)
            for nei in graph[email]:
                if nei not in visited:
                    dfs(nei, visited)
        
        visited = set()
        res = []
        for email in graph:
            if email not in visited:
                emails = []
                dfs(email, visited)
                for email in visited:
                    emails.append(email)
                res.append([name] + sorted(emails))
        return res