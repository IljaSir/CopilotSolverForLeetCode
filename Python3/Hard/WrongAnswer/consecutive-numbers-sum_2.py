class Solution:
    def consecutiveNumbersSum(self, n: int) -> int:
        
        ans = 0
        for k in range(1, int(n**0.5) + 1):
            if (n - k * (k - 1) // 2) % k == 0:
                ans += 1
        return ans