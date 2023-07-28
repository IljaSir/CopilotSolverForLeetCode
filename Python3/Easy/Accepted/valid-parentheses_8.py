class Solution:
    def isValid(self, s: str) -> bool:
        
        if len(s) % 2 == 1:
            return False
        if s == "":
            return True
        stack = []
        for ch in s:
            if ch == "(" or ch == "[" or ch == "{":
                stack.append(ch)
            elif ch == ")" or ch == "]" or ch == "}":
                if len(stack) == 0:
                    return False
                if ch == ")" and stack[-1] == "(":
                    stack.pop()
                elif ch == "]" and stack[-1] == "[":
                    stack.pop()
                elif ch == "}" and stack[-1] == "{":
                    stack.pop()
                else:
                    return False
        return len(stack) == 0