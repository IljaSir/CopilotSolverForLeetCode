class Solution:
    def superpalindromesInRange(self, left: str, right: str) -> int:
        
        def isPalindrome(x):
            return str(x) == str(x)[::-1]
        def isSuperPalindrome(x):
            return isPalindrome(x) and isPalindrome(x**0.5)
        l = int(left)
        r = int(right)
        count = 0
        for i in range(1, 100000):
            s = str(i)
            t = s + s[-2::-1]
            v = int(t)**2
            if v > r: break
            if v >= l and isSuperPalindrome(v):
                count += 1
        for i in range(1, 100000):
            s = str(i)
            t = s + s[::-1]
            v = int(t)**2
            if v > r: break
            if v >= l and isSuperPalindrome(v):
                count += 1
        return count