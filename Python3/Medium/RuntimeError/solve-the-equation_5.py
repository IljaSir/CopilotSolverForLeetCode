class Solution:
    def solveEquation(self, equation: str) -> str:
        
        equation = equation.replace('x', 'x+')
        equation = equation + '+'
        left, right = equation.split('=')
        left = left.replace('x', '1x')
        right = right.replace('x', '1x')
        left = left.replace('-', '+-')
        right = right.replace('-', '+-')
        left = left.split('+')
        right = right.split('+')
        left = [int(i) for i in left if i != '']
        right = [int(i) for i in right if i != '']
        left_sum = sum(left)
        right_sum = sum(right)
        if left_sum == right_sum:
            if len(left) == len(right):
                return 'Infinite solutions'
            else:
                return 'x=0'
        else:
            return 'x={}'.format((right_sum - left_sum) // (len(left) - len(right)))