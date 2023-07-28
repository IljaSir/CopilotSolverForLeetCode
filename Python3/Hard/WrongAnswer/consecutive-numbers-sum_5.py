class Solution:
    def consecutiveNumbersSum(self, n: int) -> int:
        
        count = 0
        for i in range(1, n+1):
            if (2*n - i*(i-1)) % (2*i) == 0:
                count += 1
        return count