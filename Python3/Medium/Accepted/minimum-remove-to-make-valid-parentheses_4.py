class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        
        stack = []
        invalid = set()
        for i, c in enumerate(s):
            if c == '(':
                stack.append(i)
            elif c == ')':
                if stack:
                    stack.pop()
                else:
                    invalid.add(i)
        invalid |= set(stack)
        return "".join(c for i, c in enumerate(s) if i not in invalid)