class Solution:
    def superpalindromesInRange(self, left: str, right: str) -> int:
        
        def isPalindrome(x):
            return str(x) == str(x)[::-1]
        def isSuperPalindrome(x):
            return isPalindrome(x) and isPalindrome(int(x ** 0.5))
        left, right = int(left), int(right)
        result = 0
        for i in range(1, 10):
            if left <= i * i <= right:
                result += 1
        for i in range(1, 10 ** 5):
            s = str(i)
            p = int(s + s[-2::-1])
            if p * p > right:
                break
            if left <= p * p <= right and isSuperPalindrome(p * p):
                result += 1
        for i in range(1, 10 ** 5):
            s = str(i)
            p = int(s + s[::-1])
            if p * p > right:
                break
            if left <= p * p <= right and isSuperPalindrome(p * p):
                result += 1
        return result