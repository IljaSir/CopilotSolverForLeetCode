class Solution:
    def solveEquation(self, equation: str) -> str:
        
        a, b, sgn = 0, 0, 1
        for x in equation.split('='):
            if sgn == 1:
                a += self.parse(x)
            else:
                b += self.parse(x)
            sgn = -1
        if a == 0:
            if b == 0:
                return 'Infinite solutions'
            else:
                return 'No solution'
        else:
            return 'x=' + str(b // a)