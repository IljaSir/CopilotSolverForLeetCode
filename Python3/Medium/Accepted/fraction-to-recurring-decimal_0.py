class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        
        if numerator % denominator == 0:
            return str(numerator // denominator)
        res = []
        if numerator * denominator < 0:
            res.append('-')
        numerator, denominator = abs(numerator), abs(denominator)
        res.append(str(numerator // denominator))
        res.append('.')
        numerator %= denominator
        dic = {}
        while numerator != 0:
            if numerator in dic:
                res.insert(dic[numerator], '(')
                res.append(')')
                break
            dic[numerator] = len(res)
            numerator *= 10
            res.append(str(numerator // denominator))
            numerator %= denominator
        return ''.join(res)