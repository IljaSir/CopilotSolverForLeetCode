class Solution:
    def consecutiveNumbersSum(self, n: int) -> int:
        
        count = 0
        for k in range(1, n + 1):
            if (n - k * (k - 1) / 2) % k == 0 and (n - k * (k - 1) / 2) / k > 0:
                count += 1
        return count