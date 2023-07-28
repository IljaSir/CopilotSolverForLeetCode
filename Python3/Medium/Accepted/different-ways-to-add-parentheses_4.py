class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        
        def compute(a, b, op):
            if op == '+':
                return a + b
            elif op == '-':
                return a - b
            else:
                return a * b
        def helper(s):
            if s.isdigit():
                return [int(s)]
            res = []
            for i, c in enumerate(s):
                if c in '+-*':
                    left = helper(s[:i])
                    right = helper(s[i+1:])
                    for l in left:
                        for r in right:
                            res.append(compute(l, r, c))
            return res
        return helper(expression)