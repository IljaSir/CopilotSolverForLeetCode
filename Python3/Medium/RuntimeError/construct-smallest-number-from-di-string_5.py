class Solution:
    def smallestNumber(self, pattern: str) -> str:
        
        # Time  complexity: O(2^n)
        # Space complexity: O(2^n)
        n = len(pattern)
        ans = []
        def dfs(i, j):
            if i == n:
                ans.append("".join(map(str, range(i, j))))
            elif pattern[i] == 'I':
                dfs(i + 1, j)
            else:
                for k in range(i, j):
                    ans.append("".join(map(str, range(i, k) + [j] + range(k, j))))
                    dfs(i + 1, k)
                    dfs(k + 1, j)
        dfs(0, n + 1)
        return min(ans)