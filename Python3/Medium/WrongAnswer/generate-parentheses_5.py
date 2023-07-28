class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        if n == 0:
            return []
        if n == 1:
            return ["()"]
        result = []
        for i in range(n):
            for left in self.generateParenthesis(i):
                for right in self.generateParenthesis(n - 1 - i):
                    result.append("(" + left + ")" + right)
        return result