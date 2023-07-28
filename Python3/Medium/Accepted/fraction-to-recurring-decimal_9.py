class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        
        if numerator == 0:
            return '0'
        sign = '-' if numerator * denominator < 0 else ''
        numerator, denominator = abs(numerator), abs(denominator)
        res = [str(numerator // denominator)]
        remainder = numerator % denominator
        if remainder == 0:
            return sign + res[0]
        res.append('.')
        pos = {}
        while remainder != 0:
            if remainder in pos:
                res.insert(pos[remainder], '(')
                res.append(')')
                break
            pos[remainder] = len(res)
            remainder *= 10
            res.append(str(remainder // denominator))
            remainder %= denominator
        return sign + ''.join(res)