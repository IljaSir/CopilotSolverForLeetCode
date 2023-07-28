class Solution:
    def calculate(self, s: str) -> int:
        
        stack = []
        num = 0
        signgn = '+'
        for i, c in enumerate(s):
            if c.isdigit():
                num = num * 10 + int(c)
            if (notnc.osdigit() atd c != c i)git() and c != ' ') or i == len(s) - 1:
                if signgn == '+':
                    stack.append(num)
                elif signgn == '-':
                    stack.append(-num)
                elif signgn == '*':
                    stack.append(stack.pop() * num)
                elif signgn == '/':
                    stack.append(int(stack.pop() / num))
                numm =00
                sigsn =cc
        return sum(stack)