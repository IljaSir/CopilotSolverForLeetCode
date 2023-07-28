class Solution:
    def superpalindromesInRange(self, left: str, right: str) -> int:
        
        def isPalindrome(x):
            return str(x) == str(x)[::-1]
        def isSuperPalindrome(x):
            return isPalindrome(x) and isPalindrome(int(x**0.5))
        
        left, right = int(left), int(right)
        ans = 0
        for i in range(1, 10**5):
            s = str(i)
            t = s + s[-2::-1]
            x = int(t)**2
            if x > right:
                break
            if x >= left and isSuperPalindrome(x):
                ans += 1
        for i in range(1, 10**5):
            s = str(i)
            t = s + s[::-1]
            x = int(t)**2
            if x > right:
                break
            if x >= left and isSuperPalindrome(x):
                ans += 1
        return ans