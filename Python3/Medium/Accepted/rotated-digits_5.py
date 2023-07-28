class Solution:
    def rotatedDigits(self, n: int) -> int:
        
        def check(n):
            s = set(str(n))
            return '3' not in s and '4' not in s and '7' not in s and len(s & {'2', '5', '6', '9'}) > 0
        return sum(check(i) for i in range(1, n + 1))