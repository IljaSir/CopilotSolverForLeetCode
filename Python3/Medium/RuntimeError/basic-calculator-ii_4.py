class Solution:
    def calculate(self, s: str) -> int:
        
        s = s.replace(' ', '')
        stack = []
        i = 0
        while i < len(s):
            if s[i] in '+-*/':
                stack.append(s[i])
                i += 1
            else:
                j = i + 1
                while j < len(s) and s[j] in '0123456789':
                    j += 1
                stack.append(int(s[i:j]))
                i = j
        i = 1
        while i < len(stack):
            if stack[i] in '*/':
                a, b = stack[i-1], stack[i+1]
                if stack[i] == '*':
                    stack[i-1:i+2] = [a * b]
                else:
                    stack[i-1:i+2] = [a // b]
            else:
                i += 2
        i = 1
        while i < len(stack):
            if stack[i] == '+':
                stack[i-1:i+1] = [stack[i-1] + stack[i+1]]
            else:
                stack[i-1:i+1] = [stack[i-1] - stack[i+1]]
        return stack[0]