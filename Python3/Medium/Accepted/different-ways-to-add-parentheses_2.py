class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        
        def helper(expression):
            if expression.isdigit():
                return [int(expression)]
            res = []
            for i, c in enumerate(expression):
                if c in "+-*":
                    left = helper(expression[:i])
                    right = helper(expression[i+1:])
                    for l in left:
                        for r in right:
                            if c == "+":
                                res.append(l + r)
                            elif c == "-":
                                res.append(l - r)
                            else:
                                res.append(l * r)
            return res
        return helper(expression)