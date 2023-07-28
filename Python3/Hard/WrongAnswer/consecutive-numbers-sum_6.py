class Solution:
    def consecutiveNumbersSum(self, n: int) -> int:
        
        count = 0
        for i in range(1, n+1):
            if n % i == 0:
                if i % 2 == 1 and n // i >= i // 2:
                    count += 1
                elif i % 2 == 0 and n // i >= i // 2 + 1:
                    count += 1
        return count