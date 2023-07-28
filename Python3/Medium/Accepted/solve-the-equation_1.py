class Solution:
    def solveEquation(self, equation: str) -> str:
        
        left, right = equation.split('=')
        left = left.replace('-', '+-')
        right = right.replace('-', '+-')
        left = left.split('+')
        right = right.split('+')
        left = [x for x in left if x]
        right = [x for x in right if x]
        x = 0
        c = 0
        for l in left:
            if l == 'x':
                x += 1
            elif l == '-x':
                x -= 1
            elif l[-1] == 'x':
                x += int(l[:-1])
            else:
                c -= int(l)
        for r in right:
            if r == 'x':
                x -= 1
            elif r == '-x':
                x += 1
            elif r[-1] == 'x':
                x -= int(r[:-1])
            else:
                c += int(r)
        if x == 0:
            if c == 0:
                return 'Infinite solutions'
            else:
                return 'No solution'
        else:
            return 'x=' + str(c//x)