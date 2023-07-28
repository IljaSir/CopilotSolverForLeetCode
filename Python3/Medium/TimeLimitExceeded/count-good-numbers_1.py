class Solution:
    def countGoodNumbers(self, n: int) -> int:
        
        if n == 1:
            return 5
        if n % 2 == 0:
            return (5 ** (n // 2) * 4 ** (n // 2)) % (10 ** 9 + 7)
        else:
            return (5 ** (n // 2) * 4 ** (n // 2) * 5) % (10 ** 9 + 7)