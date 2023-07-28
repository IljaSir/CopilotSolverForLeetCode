class Solution:
    def calculate(self, s: str) -> int:
        
        s = s.replace(" ", "")
        s = s.replace("-", "+-")
        s = s.replace("*", " * ")
        s = s.replace("/", " / ")
        s = s.replace("+", " + ")
        s = s.split()
        stack = []
        for token in s:
            if token == "*":
                stack.append(stack.pop()*int(s.pop(0)))
            elif token == "/":
                stack.append(stack.pop()//int(s.pop(0)))
            else:
                stack.append(int(token))
        return sum(stack)