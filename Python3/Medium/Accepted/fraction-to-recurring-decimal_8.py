class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        
        sign = '-' if numerator * denominator < 0 else ''
        numerator, denominator = abs(numerator), abs(denominator)
        integer_part = numerator // denominator
        remainder = numerator % denominator
        if remainder == 0:
            return sign + str(integer_part)
        decimal_part = []
        remainder_map = {}
        while remainder:
            if remainder in remainder_map:
                decimal_part.insert(remainder_map[remainder], '(')
                decimal_part.append(')')
                break
            remainder_map[remainder] = len(decimal_part)
            remainder *= 10
            decimal_part.append(str(remainder // denominator))
            remainder %= denominator
        return sign + str(integer_part) + '.' + ''.join(decimal_part)