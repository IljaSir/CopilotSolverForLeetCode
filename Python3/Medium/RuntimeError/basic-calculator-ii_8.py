class Solution:
    def calculate(self, s: str) -> int:
        
        s = s.replace(" ", "")
        stack = []
        i = 0
        while i < len(s):
            if s[i].isdigit():
                if stack and stack[-1] in ["*", "/"]:
                    op = stack.pop()
                    num = stack.pop()
                    if op == "*":
                        stack.append(num * int(s[i]))
                    else:
                        stack.append(int(num / int(s[i])))
                else:
                    stack.append(int(s[i]))
            else:
                stack.append(s[i])
            i += 1
        res = stack[0]
        i = 1
        while i < len(stack):
            if stack[i] == "+":
                res += stack[i+1]
            else:
                res -= stack[i+1]
            i += 2
        return res