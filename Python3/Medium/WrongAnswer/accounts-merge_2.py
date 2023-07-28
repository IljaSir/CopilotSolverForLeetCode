class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        
        graph = collections.defaultdict(list)
        for account in accounts:
            for i in range(1, len(account)):
                graph[account[i]].append(account[1])
                graph[account[1]].append(account[i])
        visited = set()
        result = []
        for account in accounts:
            name = account[0]
            emails = account[1:]
            if emails[0] in visited:
                continue
            visited.add(emails[0])
            stack = [emails[0]]
            while stack:
                email = stack.pop()
                for e in graph[email]:
                    if e not in visited:
                        visited.add(e)
                        stack.append(e)
                        emails.append(e)
            result.append([name] + sorted(emails))
        return result