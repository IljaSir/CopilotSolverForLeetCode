class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        
        self.memo = {}
        return self.helper(expression)