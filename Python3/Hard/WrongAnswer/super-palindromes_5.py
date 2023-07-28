class Solution:
    def superpalindromesInRange(self, left: str, right: str) -> int:
        
        left = int(left)
        right = int(right)
        def isPalindrome(s):
            return s == s[::-1]
        def isSuperPalindrome(s):
            return isPalindrome(s) and isPalindrome(str(int(s)**0.5))
        def gen():
            for i in range(10**5):
                s = str(i)
                yield int(s + s[-2::-1])
                yield int(s + s[::-1])
        return sum(isSuperPalindrome(str(x**2)) for x in gen() if left <= x**2 <= right)