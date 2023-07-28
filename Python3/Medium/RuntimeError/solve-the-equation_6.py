class Solution:
    def solveEquation(self, equation: str) -> str:
        
        # Split equation into left and right sides
        left, right = equation.split('=')
        
        # Get coefficients and constants from left and right sides
        left_coeff, left_const = self.parse(left)
        right_coeff, right_const = self.parse(right)
        
        # If coefficients are equal, check if constants are equal
        if left_coeff == right_coeff:
            if left_const == right_const:
                return 'Infinite solutions'
            else:
                return 'No solution'
        
        # If coefficients are not equal, calculate value of x
        else:
            return 'x={}'.format((right_const - left_const) // (left_coeff - right_coeff))