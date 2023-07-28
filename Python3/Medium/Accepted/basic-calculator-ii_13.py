class Solution:
    def calculate(self, s: str) -> int:
        
        # 1st solution
        # 1. use stack to store numbers
        # 2. use a variable to store last operator
        # 3. if current operator is + or -, then push number into stack
        # 4. if current operator is * or /, then pop number from stack and do calculation, then push result into stack
        # 5. finally, sum up all numbers in stack
        # O(n) time and O(n) space
        stack = []
        last_op = '+'
        num = 0
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            if s[i] in '+-*/' or i == len(s) - 1:
                if last_op == '+':
                    stack.append(num)
                elif last_op == '-':
                    stack.append(-num)
                elif last_op == '*':
                    stack.append(stack.pop() * num)
                elif last_op == '/':
                    stack.append(int(stack.pop() / num))
                last_op = s[i]
                num = 0
        return sum(stack)