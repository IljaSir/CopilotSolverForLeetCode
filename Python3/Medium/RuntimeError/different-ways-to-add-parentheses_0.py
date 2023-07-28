class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        
        if expression.isdigit():
            return [int(expression)]
        res = []
        for i, c in enumerate(expression):
            if c in '+-*':
                left = self.diffWaysToCompute(expression[:i])
                right = self.diffWaysToCompute(expression[i+1:])
                for l in left:
                    for r in right:
                        res.append(self.helper(l, r, c))
        return res