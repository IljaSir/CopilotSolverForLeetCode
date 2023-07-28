class Solution:
    def solveEquation(self, equation: str) -> str:
        
        left, right = equation.split('=')
        left = left.split('+')
        right = right.split('+')
        left = [i.split('-') for i in left]
        left = [i for j in left for i in j]
        right = [i.split('-') for i in right]
        right = [i for j in right for i in j]
        left = [i for i in left if i]
        right = [i for i in right if i]
        left = [i for i in left if i != 'x']
        right = [i for i in right if i != 'x']
        left = [i for i in left if i != '-x']
        right = [i for i in right if i != '-x']
        left = [i for i in left if i != '+x']
        right = [i for i in right if i != '+x']
        left = [i for i in left if i != '-']
        right = [i for i in right if i != '-']
        left = [i for i in left if i != '+']
        right = [i for i in right if i != '+']
        left = [int(i) for i in left]
        right = [int(i) for i in right]
        left = [i if 'x' not in i else int(i[:-1]) for i in left]
        right = [i if 'x' not in i else int(i[:-1]) for i in right]
        left = [i if 'x' not in i else int(i[:-1]) for i in left]
        right = [i if 'x' not in i else int(i[:-1]) for i in right]
        left = [i if 'x' not in i else int(i[:-1]) for i in left]
        right = [i if 'x' not in i else int(i[:-1]) for i in right]
        left = [i if 'x' not in i else int(i[:-1]) for i in left]
        right = [i if 'x' not in i else int(i[:-1]) for i in right]
        left = [i if 'x' not in i else int(i[:-1]) for i in left]
        right = [i if 'x' not in i else int(i[:-1]) for i in