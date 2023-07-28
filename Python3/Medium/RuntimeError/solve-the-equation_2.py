class Solution:
    def solveEquation(self, equation: str) -> str:
        
        l, r = equation.split('=')
        l = l.replace('+', ' +').replace('-', ' -').split()
        r = r.replace('+', ' +').replace('-', ' -').split()
        lc, rc = 0, 0
        for i in l:
            if i == 'x':
                lc += 1
            elif i[0] == 'x':
                lc += int(i[1:])
            else:
                rc -= int(i)
        for i in r:
            if i == 'x':
                lc -= 1
            elif i[0] == 'x':
                lc -= int(i[1:])
            else:
                rc += int(i)
        if lc == 0:
            if rc == 0:
                return 'Infinite solutions'
            else:
                return 'No solution'
        else:
            return 'x={}'.format(rc//lc)