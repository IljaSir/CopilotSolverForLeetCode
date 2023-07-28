class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        
        if numerator % denominator == 0:
            return str(numerator // denominator)
        res = []
        if numerator < 0 and denominator > 0 or numerator > 0 and denominator < 0:
            res.append('-')
        numerator, denominator = abs(numerator), abs(denominator)
        res.append(str(numerator // denominator))
        res.append('.')
        numerator %= denominator
        rmap = {}
        while numerator:
            if numerator in rmap:
                res.insert(rmap[numerator], '(')
                res.append(')')
                break
            rmap[numerator] = len(res)
            numerator *= 10
            res.append(str(numerator // denominator))
            numerator %= denominator
        return ''.join(res)