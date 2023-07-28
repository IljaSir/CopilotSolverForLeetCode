class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        
        # O(n^2) time
        # O(n) space
        # union find
        # email: index
        email_index = {}
        # index: name
        index_name = {}
        # index: set of emails
        index_emails = {}
        for i, account in enumerate(accounts):
            name = account[0]
            for email in account[1:]:
                if email not in email_index:
                    email_index[email] = i
                    index_name[i] = name
                    index_emails[i] = set([email])
                else:
                    j = email_index[email]
                    index_emails[j].add(email)
        # union find
        parent = {i: i for i in range(len(accounts))}
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        def union(x, y):
            x, y = find(x), find(y)
            if x != y:
                parent[x] = y
        for i in range(len(accounts)):
            for email in index_emails[i]:
                j = email_index[email]
                if i != j:
                    union(i, j)
        # merge emails
        res = []
        for i in range(len(accounts)):
            i = find(i)
            if i not in res:
                res.append(i)
        for i in res:
            emails = sorted(index_emails[i])
            emails.insert(0, index_name[i])
            res[i] = emails
        return res