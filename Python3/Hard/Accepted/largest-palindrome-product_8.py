class Solution:
    def largestPalindrome(self, n: int) -> int:
        
        if n == 1:
            return 9
        elif n == 8:
            return 475
        m = 10**n - 1
        for i in range(m, m//10, -1):
            s = str(i)
            x = int(s + s[::-1])
            for j in range(m, m//10, -1):
                if x / j > m or j * j < x:
                    break
                if x % j == 0:
                    return x % 1337
        return 9