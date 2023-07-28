class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        
        digits = [int(x) for x in str(n)]
        product = 1
        for digit in digits:
            product *= digit
        return product - sum(digits)