class Solution:
    def numSquares(self, n: int) -> int:
        
        if int(sqrt(n)) == sqrt(n):
            return 1
        while n % 4 == 0:
            n /= 4
        if n % 8 == 7:
            return 4
        for a in range(int(sqrt(n)) + 1):
            b = int(sqrt(n - a * a))
            if a * a + b * b == n:
                return (not not a) + (not not b)
        return 3