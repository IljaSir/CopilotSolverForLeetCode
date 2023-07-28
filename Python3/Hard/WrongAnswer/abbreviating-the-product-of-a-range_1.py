class Solution:
    def abbreviateProduct(self, left: int, right: int) -> str:
        
        product = 1
        for i in range(left, right+1):
            product *= i
        s = str(product)
        if len(s) <= 10:
            return s
        count = 0
        while s[-1] == '0':
            s = s[:-1]
            count += 1
        return s[:5] + '...' + s[-5:] + 'e' + str(count)