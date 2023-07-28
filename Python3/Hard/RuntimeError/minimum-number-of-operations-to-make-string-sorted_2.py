class Solution:
    def makeStringSorted(self, s: str) -> int:
        
        MOD = 10**9 + 7
        def fact(n):
            return reduce(lambda a, b: a * b % MOD, range(1, n + 1))
        def count(s, i):
            return sum(s[j] < s[i] for j in range(i + 1, len(s)))
        def perm(s):
            if not s:
                return 1
            c = count(s, 0)
            return c * fact(len(s) - 1) * perm(s[1:]) % MOD
        res = 0
        for i in range(len(s)):
            c = count(s, i)
            res = (res + c * fact(len(s) - i - 1)) % MOD
            s = s[:i] + s[i + 1:]
        return (perm(s) - res - 1) % MOD