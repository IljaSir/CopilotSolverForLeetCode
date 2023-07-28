class Solution:
    def consecutiveNumbersSum(self, n: int) -> int:
        
        i = 1
        res = 0
        while i * (i + 1) // 2 <= n:
            if (n - i * (i + 1) // 2) % (i + 1) == 0:
                res += 1
            i += 1
        return res