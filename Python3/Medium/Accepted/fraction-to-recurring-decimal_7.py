class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        
        if numerator == 0:
            return '0'
        sign = '-' if numerator * denominator < 0 else ''
        numerator, denominator = abs(numerator), abs(denominator)
        ans = sign + str(numerator // denominator)
        remainder = numerator % denominator
        if remainder == 0:
            return ans
        ans += '.'
        remainder *= 10
        visited = {}
        while remainder != 0:
            if remainder in visited:
                ans = ans[:visited[remainder]] + '(' + ans[visited[remainder]:] + ')'
                break
            visited[remainder] = len(ans)
            ans += str(remainder // denominator)
            remainder = remainder % denominator * 10
        return ans