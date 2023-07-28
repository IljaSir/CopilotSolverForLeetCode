class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        
        if numerator == 0:
            return '0'
        res = []
        if numerator*denominator < 0:
            res.append('-')
        numerator = abs(numerator)
        denominator = abs(denominator)
        res.append(str(numerator//denominator))
        numerator = numerator%denominator
        if numerator == 0:
            return ''.join(res)
        res.append('.')
        num_dict = {}
        while numerator:
            if numerator in num_dict:
                res.insert(num_dict[numerator], '(')
                res.append(')')
                break
            num_dict[numerator] = len(res)
            numerator *= 10
            res.append(str(numerator//denominator))
            numerator = numerator%denominator
        return ''.join(res)