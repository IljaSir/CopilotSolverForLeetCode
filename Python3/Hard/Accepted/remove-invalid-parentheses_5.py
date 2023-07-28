class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        def isValid(s):
            cnt = 0
            for ch in s:
                if ch == '(':
                    cnt += 1
                elif ch == ')':
                    cnt -= 1
                    if cnt < 0:
                        return False
            return cnt == 0
        
        def dfs(s, i, l, r, res):
            if i == len(s):
                if l == 0 and r == 0:
                    res.add(s)
                return
            if s[i] == '(' and l > 0:
                dfs(s[:i] + s[i + 1:], i, l - 1, r, res)
            if s[i] == ')' and r > 0:
                dfs(s[:i] + s[i + 1:], i, l, r - 1, res)
            if s[i] != '(' and s[i] != ')':
                dfs(s, i + 1, l, r, res)
            else:
                dfs(s, i + 1, l, r, res)
        
        l = r = 0
        for ch in s:
            if ch == '(':
                l += 1
            elif ch == ')':
                if l > 0:
                    l -= 1
                else:
                    r += 1
        res = set()
        dfs(s, 0, l, r, res)
        return list(filter(isValid, res))