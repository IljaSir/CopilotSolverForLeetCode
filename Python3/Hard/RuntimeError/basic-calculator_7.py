class Solution:
    def calculate(self, s: str) -> int:
        
        s = s.replace(' ', '')
        stack = []
        for i in range(len(s)):
            if s[i] == ')':
                temp = []
                while stack[-1] != '(':
                    temp.append(stack.pop())
                stack.pop()
                stack.append(self.calculate_str(temp))
            else:
                stack.append(s[i])
        return self.calculate_str(stack)