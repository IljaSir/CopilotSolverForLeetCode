class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        
        if expression.isdigit():
            return [int(expression)]
        res = []
        for i, c in enumerate(expression):
            if c in "+-*":
                for a in self.diffWaysToCompute(expression[:i]):
                    for b in self.diffWaysToCompute(expression[i+1:]):
                        if c == '+':
                            res.append(a+b)
                        elif c == '-':
                            res.append(a-b)
                        else:
                            res.append(a*b)
        return res