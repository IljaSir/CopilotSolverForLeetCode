class Solution:
    def largestPalindrome(self, n: int) -> int:
        
        if n == 1:
            return 9
        upper = 10**n - 1
        lower = upper // 10
        for i in range(upper, lower, -1):
            start = int(str(i) + str(i)[::-1])
            for j in range(upper, lower, -1):
                if start // j > upper: break
                if start % j == 0:
                    return start % 1337
        return -1