class Solution:
    def largestPalindrome(self, n: int) -> int:
        
        if n == 1:
            return 9
        upper = 10**n - 1
        lower = 10**(n-1)
        for i in range(upper, lower-1, -1):
            pal = int(str(i) + str(i)[::-1])
            for j in range(upper, lower-1, -1):
                if j*j < pal:
                    break
                if pal % j == 0:
                    return pal % 1337