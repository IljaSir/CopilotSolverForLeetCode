class Solution:
    def countDigitOne(self, n: int) -> int:
        
        if n <= 0:
            return 0
        m = 1
        cnt = 0
        while m <= n:
            cnt += (n // m + 8) // 10 * m + (n // m % 10 == 1) * (n % m + 1)
            m *= 10
        return cnt