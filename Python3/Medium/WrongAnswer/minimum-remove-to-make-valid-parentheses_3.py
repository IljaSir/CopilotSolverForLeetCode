class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        
        stack = []
        for i, c in enumerate(s):
            if c == "(":
                stack.append(i)
            elif c == ")":
                if stack and s[stack[-1]] == "(":
                    stack.pop()
                else:
                    stack.append(i)
        ans = ""
        for i, c in enumerate(s):
            if not stack:
                ans += s[i:]
                break
            if i == stack[-1]:
                stack.pop()
                continue
            ans += c
        return ans