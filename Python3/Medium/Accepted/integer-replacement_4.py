class Solution:
    def integerReplacement(self, n: int) -> int:
        
        def f(n):
            if n == 1:
                return 0
            if n % 2 == 0:
                return f(n // 2) + 1
            else:
                return min(f(n + 1), f(n - 1)) + 1
        return f(n)