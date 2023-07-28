class Solution:
    def countAnagrams(self, s: str) -> int:
        
        def fact(n):
            if n == 0:
                return 1
            return n * fact(n-1)
        def perm(n, k):
            if k == 0:
                return 1
            return n * perm(n-1, k-1)
        def countAnagrams(s):
            if len(s) == 0:
                return 0
            if len(s) == 1:
                return 1
            s = s.split()
            n = len(s)
            ans = 1
            for i in range(n):
                ans *= perm(len(s[i]), len(s[i]))
            ans *= fact(n)
            return ans
        return countAnagrams(s) % (10**9 + 7)