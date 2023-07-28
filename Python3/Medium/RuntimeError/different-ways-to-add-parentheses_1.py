class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        
        if expression.isdigit():
            return [int(expression)]
        res = []
        for i, c in enumerate(expression):
            if c in '+-*':
                left = self.diffWaysToCompute(expression[:i])
                right = self.diffWaysToCompute(expression[i+1:])
                for n1 in left:
                    for n2 in right:
                        res.append(self.helper(n1, n2, c))
        return res