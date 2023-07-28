class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        
        stack = []
        result = ""
        for char in s:
            if len(stack) == 0:
                stack.append(char)
            elif stack[-1] == "(" and char == ")":
                stack.pop()
                if len(stack) > 0:
                    result += char
            else:
                stack.append(char)
                result += char
        return result