class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        if not s:
            return [""]
        stack = []
        for i, ch in enumerate(s):
            if ch == "(":
                stack.append([i, 0])
            elif ch == ")":
                if stack and stack[-1][1] == 0:
                    stack.pop()
                else:
                    stack.append([i, 1])
        if not stack:
            return [s]
        res = []
        def dfs(i, stack, s):
            if i == len(s):
                if not stack:
                    res.append(s)
                return
            if stack and s[i] == stack[-1][1]:
                stack.pop()
                dfs(i+1, stack, s[:i] + s[i+1:])
                stack.append([i, s[i]])
            dfs(i+1, stack, s)
        dfs(0, stack, s)
        return res