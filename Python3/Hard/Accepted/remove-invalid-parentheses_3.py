class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        def is_valid(s):
            count = 0
            for c in s:
                if c == '(':
                    count += 1
                elif c == ')':
                    count -= 1
                    if count < 0:
                        return False
            return count == 0
        def dfs(s, start, left, right, res):
            if left == 0 and right == 0:
                if is_valid(s):
                    res.append(s)
                return
            for i in range(start, len(s)):
                if i != start and s[i] == s[i - 1]:
                    continue
                if s[i] == '(' and left > 0:
                    dfs(s[:i] + s[i + 1:], i, left - 1, right, res)
                if s[i] == ')' and right > 0:
                    dfs(s[:i] + s[i + 1:], i, left, right - 1, res)
        left = right = 0
        for c in s:
            if c == '(':
                left += 1
            elif c == ')':
                if left > 0:
                    left -= 1
                else:
                    right += 1
        res = []
        dfs(s, 0, left, right, res)
        return res