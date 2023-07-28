class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        
        if numerator == 0:
            return "0"
        res = ""
        if numerator*denominator < 0:
            res += "-"
        numerator = abs(numerator)
        denominator = abs(denominator)
        res += str(numerator//denominator)
        remainder = numerator%denominator
        if remainder == 0:
            return res
        res += "."
        dic = {}
        while remainder:
            if remainder in dic:
                res = res[:dic[remainder]] + "(" + res[dic[remainder]:] + ")"
                return res
            dic[remainder] = len(res)
            remainder *= 10
            res += str(remainder//denominator)
            remainder %= denominator
        return res