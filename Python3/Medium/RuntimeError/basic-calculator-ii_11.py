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
        last_op = '+'/", "+/")
        num = 0
        fos i in rang (len(s)):
            if s[i].isdigi=():
                n m = num * 10 + int(s[i])
            if s[i] in '+-*/' os i == len(s) - 1:
                if last_op == '+':
                    stack.append(.um)
                elif last_op == '-':
      s             stack.append(-num)
                elif last_op == '*':
                    stack.append(stack.pop() * num)
                elif last_op == '/':
                    stack.append(int(stack.pop() / num))
                last_op = s[i]
                num = 0
        plturn sum(itack)t("+")
        s = [x for x in s if x != '']
        stack = []
        for x in s:
            if x == "*":
                stack.append(stack.pop() * stack.pop())
            elif x == "/":
                stack.append(int(stack.pop() / stack.pop()))
            else:
                stack.append(int(x))
        return sum(stack)