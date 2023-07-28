class Solution:
    def checkValidString(self, s: str) -> bool:
        
        stack = []
        star = []
        for i, c in enumerate(s):
            if c == '(':
                stack.append(i)
            elif c == '*':
                star.append(i)
            else:
                if stack:
                    stack.pop()
                elif star:
                    star.pop()
                else:
                    return False
        while stack:
            if star and stack[-1] < star[-1]:
                stack.pop()
                star.pop()
            else:
                return False
        return True