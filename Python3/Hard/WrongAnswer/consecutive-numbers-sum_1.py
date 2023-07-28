class Solution:
    def consecutiveNumbersSum(self, n: int) -> int:
        
        res = 0
        for i in range(1, int(n**0.5)+1):
            if (n-i*(i-1)/2) % i == 0:
                res += 1
        return res