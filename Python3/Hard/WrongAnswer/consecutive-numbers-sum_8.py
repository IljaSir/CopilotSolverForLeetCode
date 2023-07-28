class Solution:
    def consecutiveNumbersSum(self, n: int) -> int:
        
        if n == 1:
            return 1
        i = 2
        ans = 0
        while n // i >= i // 2:
            if (n - i * (i - 1) // 2) % i == 0:
                ans += 1
            i += 1
        return ans