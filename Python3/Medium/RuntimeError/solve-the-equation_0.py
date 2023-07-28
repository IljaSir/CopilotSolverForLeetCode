class Solution:
    def solveEquation(self, equation: str) -> str:
        
        left, right = equation.split('=')
        left = left.replace('+', ' +').replace('-', ' -').split()
        right = right.replace('+', ' +').replace('-', ' -').split()
        left, right = self.count(left), self.count(right)
        if left[0] == right[0]:
            if left[1] == right[1]:
                return "Infinite solutions"
            else:
                return "No solution"
        else:
            return "x={}".format((right[1] - left[1]) // (left[0] - right[0]))