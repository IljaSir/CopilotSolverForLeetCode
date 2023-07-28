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
        numerator = numerator % denominator
        seen = {}
        while numerator != 0:
            if numerator in seen:
                res.insert(seen[numerator], '(')
                res.append(')')
                break
            seen[numerator] = len(res)
            numerator *= 10
            res.append(str(numerator // denominator))
            numerator = numerator % denominator
        return ''.join(res)