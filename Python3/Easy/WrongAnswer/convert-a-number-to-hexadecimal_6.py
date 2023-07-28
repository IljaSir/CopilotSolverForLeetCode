class Solution:
    def toHex(self, num: int) -> str:
        
        if num == 0:
            return '0'
        hexa = "0123456789abcdef"
        n = abs(num)
        ans = ""
        while n:
            ans += hexa[n % 16]
            n //= 16
        if num < 0:
            ans = ans.zfill(8)
            ans = ans[::-1]
            ans = ''.join([hexa[15 - hexa.index(c)] for c in ans])
        return ans[::-1]