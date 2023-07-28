class Solution:
    def largestPalindrome(self, n: int) -> int:
        
        if n == 1:
            return 9
        high = 10**n - 1
        low = 10**(n-1)
        for i in range(high, low-1, -1):
            temp = int(str(i) + str(i)[::-1])
            for j in range(high, low-1, -1):
                if temp // j > high:
                    break
                if temp % j == 0:
                    return temp % 1337
        return -1