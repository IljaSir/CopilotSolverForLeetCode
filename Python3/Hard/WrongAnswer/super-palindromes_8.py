class Solution:
    def superpalindromesInRange(self, left: str, right: str) -> int:
        
        def ispal(s):
            return s == s[::-1]
        def genpal(n):
            s = str(n)
            return int(s + s[-2::-1])
        l, r = int(left), int(right)
        ans = 0
        for i in range(1, 10**5):
            p = genpal(i)
            s = p * p
            if s > r:
                break
            if s >= l and ispal(str(s)):
                ans += 1
        for i in range(1, 10**5):
            p = genpal(i)
            s = p * p
            t = s // 10
            if t > r:
                break
            if t >= l and ispal(str(t)):
                ans += 1
        return ans