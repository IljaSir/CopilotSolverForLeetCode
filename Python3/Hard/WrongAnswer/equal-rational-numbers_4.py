class Solution:
    def isRationalEqual(self, s: str, t: str) -> bool:
        
        def get_decimal(s):
            if '(' in s:
                integer, decimal = s.split('.')
                decimal, repeat = decimal[:-1].split('(')
                return integer, decimal, repeat
            else:
                integer, decimal = s.split('.')
                return integer, decimal, ''
        integer, decimal, repeat = get_decimal(s)
        integer2, decimal2, repeat2 = get_decimal(t)
        if integer != integer2:
            return False
        if repeat == '' and repeat2 == '':
            return decimal == decimal2
        elif repeat == '' or repeat2 == '':
            return False
        else:
            return decimal == decimal2 and repeat == repeat2