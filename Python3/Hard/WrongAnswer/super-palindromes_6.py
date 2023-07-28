class Solution:
    def superpalindromesInRange(self, left: str, right: str) -> int:
        
        l, r = int(left), int(right)
        def ispalindrome(n):
            return str(n) == str(n)[::-1]
        def is_superpalindrome(n):
            return ispalindrome(n) and ispalindrome(n**0.5)
        cnt = 0
        for i in range(10**5):
            s = str(i)
            p = int(s+s[-2::-1])
            p2 = p**2
            if p2 > r:
                break
            if p2 >= l and is_superpalindrome(p2):
                cnt += 1
        for i in range(10**5):
            s = str(i)
            p = int(s+s[::-1])
            p2 = p**2
            if p2 > r:
                break
            if p2 >= l and is_superpalindrome(p2):
                cnt += 1
        return cnt