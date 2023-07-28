class Solution:
    def preimageSizeFZF(self, k: int) -> int:
        
        
        def f(x):
            if x == 0:
                return 0
            return x//5 + f(x//5)
        
        l, r = k, 10**18
        while l < r:
            m = (l + r)//2
            if f(m) < k:
                l = m + 1
            else:
                r = m
        return 5 if f(l) == k else 0