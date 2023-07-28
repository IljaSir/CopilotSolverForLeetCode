class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        
        if expression == 't':
            return True
        if expression == 'f':
            return False
        if expression[0] == '!':
            return not self.parseBoolExpr(expression[2:-1])
        if expression[0] == '&':
            return all(self.parseBoolExpr(e) for e in expression[2:-1].split(','))
        if expression[0] == '|':
            return any(self.parseBoolExpr(e) for e in expression[2:-1].split(','))