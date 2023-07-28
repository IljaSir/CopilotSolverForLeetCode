class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        def dfs(s, i, l, r, res):
            count = 0
            for j in range(i, len(s)):
                if s[j] == l:
                    count += 1
                if s[j] == r:
                    count -= 1
                if count >= 0:
                    continue
                for k in range(i, j + 1):
                    if s[k] == r and (k == i or s[k - 1] != r):
                        dfs(s[:k] + s[k + 1:], j, l, r, res)
                return
            s = s[::-1]
            if l == '(':
                dfs(s, 0, ')', '(', res)
            else:
                res.append(s)
        res = []
        dfs(s, 0, '(', ')', res)
        return res