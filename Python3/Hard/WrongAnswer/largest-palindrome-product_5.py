class Solution:
    def largestPalindrome(self, n: int) -> int:
        
        if n == 1:
            return 9
        max_num = 10 ** n - 1
        min_num = 10 ** (n - 1)
        for i in range(max_num, min_num - 1, -1):
            left = int(str(i) + str(i)[::-1])
            for j in range(max_num, int(left ** 0.5) - 1, -1):
                if left % j == 0:
                    return left % 1337
        return 0