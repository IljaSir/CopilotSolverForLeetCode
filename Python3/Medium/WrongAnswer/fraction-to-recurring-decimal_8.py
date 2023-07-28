class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        
        if numerator == 0:
            return '0'
        if denominator == 0:
            return ''
        if numerator % denominator == 0:
            return str(int(numerator / denominator))
        res = ''
        if (numerator < 0) ^ (denominator < 0):
            res += '-'
        numerator, denominator = abs(numerator), abs(denominator)
        res += str(int(numerator / denominator)) + '.'
        numerator %= denominator
        dic = {}
        while numerator != 0:
            if numerator in dic:
                res = res[:dic[numerator]] + '(' + res[dic[numerator]:] + ')'
                break
            dic[numerator] = len(res)
            numerator *= 10
            res += str(numerator / denominator)
            numerator %= denominator
        return res