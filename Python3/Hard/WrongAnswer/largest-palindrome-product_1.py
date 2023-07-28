class Solution:
    def largestPalindrome(self, n: int) -> int:
        
        if n == 1: return 9
        upper, lower = 10 ** n - 1, 10 ** (n - 1)
        for i in range(upper, lower - 1, -1):
            x = int(str(i) + str(i)[::-1])
            for j in range(upper, int(x ** 0.5) - 1, -1):
                if x % j == 0:
                    return x % 1337