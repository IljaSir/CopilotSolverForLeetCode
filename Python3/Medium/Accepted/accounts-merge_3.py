class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        
        emails = collections.defaultdict(set)
        for account in accounts:
            name = account[0]
            for email in account[1:]:
                emails[email].add(name)
        graph = collections.defaultdict(set)
        for account in accounts:
            for email in account[1:]:
                for other_email in account[1:]:
                    if email != other_email:
                        graph[email].add(other_email)
                        graph[other_email].add(email)
        seen = set()
        def dfs(email):
            if email in seen:
                return set()
            seen.add(email)
            res = set([email])
            for other_email in graph[email]:
                res |= dfs(other_email)
            return res
        res = []
        for email in emails:
            if email not in seen:
                res.append([emails[email].pop()] + sorted(list(dfs(email))))
        return res