class Solution:
    def largestPalindrome(self, n: int) -> int:
        
        if n == 1:
            return 9
        upper = 10**n - 1
        lower = 10**(n-1)
        for i in range(upper, lower-1, -1):
            j = int(str(i) + str(i)[::-1])
            for k in range(upper, lower-1, -1):
                if k * k < j:
                    break
                if j % k == 0:
                    return j % 1337
        return 0