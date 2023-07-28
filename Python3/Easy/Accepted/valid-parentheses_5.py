class Solution:
    def isValid(self, s: str) -> bool:
        
        if len(s) % 2 == 1:
            return False
        stack = []
        for c in s:
            if c == "(":
                stack.append(")")
            elif c == "[":
                stack.append("]")
            elif c == "{":
                stack.append("}")
            else:
                if len(stack) == 0 or stack[-1] != c:
                    return False
                stack.pop()
        return len(stack) == 0