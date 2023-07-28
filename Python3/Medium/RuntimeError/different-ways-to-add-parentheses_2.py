class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        
        if expression.isdigit():
            return [int(expression)]
        res = []
        for i, c in enumerate(expression):
            if c in "+-*":
                res1 = self.diffWaysToCompute(expression[:i])
                res2 = self.diffWaysToCompute(expression[i+1:])
                for r1 in res1:
                    for r2 in res2:
                        res.append(self.helper(r1, r2, c))
        return res