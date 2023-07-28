class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        
        graph = collections.defaultdict(set)
        for account in accounts:
            for i in range(1, len(account)):
                graph[account[i]].add(account[1])
                graph[account[1]].add(account[i])
        seen = set()
        def dfs(email):
            ans = [email]
            seen.add(email)
            for nei in graph[email]:
                if nei not in seen:
                    ans.extend(dfs(nei))
            return ans
        ans = []
        for email in graph:
            if email not in seen:
                ans.append([accounts[0][0]] + sorted(dfs(email)))
        return ans