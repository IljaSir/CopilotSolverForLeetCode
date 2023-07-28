class Solution:
    def consecutiveNumbersSum(self, n: int) -> int:
        
        res = 1
        for i in range(2, int((2*n)**0.5)+1):
            if (i-1)*i/2 <= n and (n - (i-1)*i/2) % i == 0:
                res += 1
        return res