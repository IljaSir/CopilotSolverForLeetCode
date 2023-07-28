class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        
        if numerator % denominator == 0:
            return str(numerator // denominator)
        sign = '-' if numerator * denominator < 0 else ''
        numerator, denominator = abs(numerator), abs(denominator)
        res = sign + str(numerator // denominator) + '.'
        numerator %= denominator
        pos = len(res)
        dic = {}
        while numerator:
            if numerator in dic:
                res = res[:dic[numerator]] + '(' + res[dic[numerator]:] + ')'
                break
            dic[numerator] = pos
            numerator *= 10
            res += str(numerator // denominator)
            numerator %= denominator
            pos += 1
        return res