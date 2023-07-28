class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        
        # union find
        d = {}
        for i, account in enumerate(accounts):
            for email in account[1:]:
                if email not in d:
                    d[email] = i
                else:
                    self.union(d, email, account[1])
        res = collections.defaultdict(set)
        for email, i in d.items():
            res[accounts[i][0]].add(email)
        return [[name] + sorted(emails) for name, emails in res.items()]