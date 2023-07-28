class Solution:
    def superpalindromesInRange(self, left: str, right: str) -> int:
        
        def isPalindrome(n):
            return str(n) == str(n)[::-1]
        def isSuperPalindrome(n):
            return isPalindrome(n) and isPalindrome(n ** 0.5)
        left, right = int(left), int(right)
        count = 0
        for i in range(1, 100000):
            s = str(i)
            for j in range(len(s) - 1, -1, -1):
                s += s[j]
            num = int(s) ** 2
            if num > right:
                break
            if num >= left and isPalindrome(num):
                count += 1
        return count