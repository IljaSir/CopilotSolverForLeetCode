class Solution:
    def basicCalculatorIV(self, expression: str, evalvars: List[str], evalints: List[int]) -> List[str]:
        
        
        # 1. replace evalvars with evalints
        # 2. tokenize the expression
        # 3. convert the expression to reverse polish notation
        # 4. evaluate the reverse polish notation
        
        # 1. replace evalvars with evalints
        for i, var in enumerate(evalvars):
            expression = expression.replace(var, str(evalints[i]))
        
        # 2. tokenize the expression
        tokens = []
        i = 0
        while i < len(expression):
            c = expression[i]
            if c == ' ':
                i += 1
            elif c.isdigit():
                j = i
                while j < len(expression) and expression[j].isdigit():
                    j += 1
                tokens.append(expression[i:j])
                i = j
            elif c in ['+', '-', '*', '(', ')']:
                tokens.append(c)
                i += 1
            else:
                j = i
                while j < len(expression) and expression[j].isalpha():
                    j += 1
                tokens.append(expression[i:j])
                i = j
        
        # 3. convert the expression to reverse polish notation
        def is_operator(token):
            return token in ['+', '-', '*']
        
        def is_operand(token):
            return token not in ['+', '-', '*', '(', ')']
        
        def get_priority(token):
            if token == '+':
                return 1
            elif token == '-':
                return 1
            elif token == '*':
                return 2
            else:
                return 0
        
        def get_rpn(tokens):
            rpn = []
            stack = []
            for token in tokens:
                if is_operand(token):
                    rpn.append(token)
                elif token == '(':
                    stack.append(token)
                elif token == ')':
                    while stack and stack[-1] != '(':
                        rpn.append(stack.pop())
                    stack.pop()
                elif is_operator(token):
                    while stack and get_priority(stack[-1]) >= get_priority(token):
                        rpn.append(stack.pop())
                    stack.append(token)
            while stack:
                rpn.append(stack.pop())
            return rpn
        
        rpn = get_rpn(tokens)
        
        # 4. evaluate the reverse polish notation
        def get_degree(token):
            if token == '0':
                return 0
            degree = 0
            for c in token: