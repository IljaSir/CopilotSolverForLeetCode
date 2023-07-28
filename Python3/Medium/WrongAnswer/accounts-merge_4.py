class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        
        d = {}
        for i, account in enumerate(accounts):
            for email in account[1:]:
                if email not in d:
                    d[email] = set()
                d[email].add(i)
        visited = set()
        res = []
        for i, account in enumerate(accounts):
            if i in visited:
                continue
            res.append([account[0]])
            stack = [i]
            visited.add(i)
            while stack:
                j = stack.pop()
                for email in accounts[j][1:]:
                    for k in d[email]:
                        if k not in visited:
                            stack.append(k)
                            visited.add(k)
                    res[-1].append(email)
            res[-1] = list(set(res[-1]))
            res[-1].sort()
        return res