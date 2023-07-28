class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        def is_valid(s):
            cnt = 0
            for c in s:
                if c == '(':
                    cnt += 1
                elif c == ')':
                    cnt -= 1
                if cnt < 0:
                    return False
            return cnt == 0
        def dfs(s, start, l, r, path, res):
            if l == 0 and r == 0:
                if is_valid(s):
                    res.append(path)
                return
            for i in range(start, len(s)):
                if i > start and s[i] == s[i-1]:
                    continue
                if r > 0 and s[i] == ')':
                    dfs(s[:i]+s[i+1:], i, l, r-1, path, res)
                if l > 0 and s[i] == '(':
                    dfs(s[:i]+s[i+1:], i, l-1, r, path, res)
        l, r = 0, 0
        for c in s:
            if c == '(':
                l += 1
            elif c == ')':
                if l > 0:
                    l -= 1
                else:
                    r += 1
        res = []
        dfs(s, 0, l, r, '', res)
        return res