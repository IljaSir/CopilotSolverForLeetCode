class Solution:
    def longestValidParentheses(self, s: str) -> int:
        
        stack = [-1]
        ans = 0
        for i, c in enumerate(s):
            if c == '(':
                stack.append(i)
            else:
                stack.pop()
                if len(stack) == 0:
                    stack.append(i)
                else:
                    ans = max(ans, i - stack[-1])
        return ans