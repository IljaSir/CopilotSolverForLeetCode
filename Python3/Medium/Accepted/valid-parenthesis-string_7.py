class Solution:
    def checkValidString(self, s: str) -> bool:
        
        stack = []
        for i in s:
            if i == "(":
                stack.append(i)
            elif i == "*":
                stack.append(i)
            else:
                if not stack:
                    return False
                if stack[-1] == "(":
                    stack.pop()
                elif stack[-1] == "*":
                    stack.pop()
                else:
                    return False
        if not stack:
            return True
        stack = []
        for i in s[::-1]:
            if i == ")":
                stack.append(i)
            elif i == "*":
                stack.append(i)
            else:
                if not stack:
                    return False
                if stack[-1] == ")":
                    stack.pop()
                elif stack[-1] == "*":
                    stack.pop()
                else:
                    return False
        return True