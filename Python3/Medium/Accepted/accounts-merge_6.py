class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        
        # Dfs
        # Time  complexity: O(AlogA)
        # Space complexity: O(A)
        graph = collections.defaultdict(list)
        email_to_name = {}
        for acc in accounts:
            name = acc[0]
            for email in acc[1:]:
                graph[acc[1]].append(email)
                graph[email].append(acc[1])
                email_to_name[email] = name
        seen = set()
        ans = []
        def dfs(node, emails):
            seen.add(node)
            emails.append(node)
            for nei in graph[node]:
                if nei not in seen:
                    dfs(nei, emails)
        for email in graph:
            if email not in seen:
                emails = []
                dfs(email, emails)
                ans.append([email_to_name[email]] + sorted(emails))
        return ans