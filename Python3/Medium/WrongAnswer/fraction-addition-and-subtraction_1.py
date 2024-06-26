class Solution:
    def fractionAddition(self, expression: str) -> str:
        
        if expression[0] != '-':
            expression = '+' + expression
        expression = expression.replace('-', '+-')
        expression = expression.split('+')
        expression = list(filter(None, expression))
        # print(expression)
        def gcd(a, b):
            if a == 0:
                return b
            return gcd(b % a, a)
        def lcm(a, b):
            return (a*b) // gcd(a, b)
        def add(a, b):
            if a[1] == b[1]:
                return [a[0]+b[0], a[1]]
            else:
                c = lcm(a[1], b[1])
                return [a[0]*(c//a[1])+b[0]*(c//b[1]), c]
        def reduce(a):
            g = gcd(a[0], a[1])
            return [a[0]//g, a[1]//g]
        def tostr(a):
            return str(a[0]) + '/' + str(a[1])
        res = [0, 1]
        for e in expression:
            e = e.split('/')
            e[0] = int(e[0])
            e[1] = int(e[1])
            res = add(res, e)
        res = reduce(res)
        if res[1] == 1:
            return str(res[0])
        else:
            return tostr(res)